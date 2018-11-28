# -*- coding: UTF-8 -*-
import dlib  # 人脸识别的库dlib
import numpy as np  # 数据处理的库numpy
import cv2  # 图像处理的库OpenCv
import csv
import os
import pandas as pd
import sys
import codecs
from datashape import unicode

# face recognition model, the object maps human faces into 128D vectors

facerec = dlib.face_recognition_model_v1(sys.argv[2]+"dlib_face_recognition_resnet_model_v1.dat")
#遍历csvs文件夹下的所有文件
#rootdir="I:/csvs/00001_admin/"
#rootdir="I:\\AccessControlSystem\\src\\main\\webapp\\csvs\\"
rootdir=sys.argv[1]
rootdir = rootdir.encode("utf-8").decode("gbk")
list=os.listdir(rootdir)
features_mean_default_person=os.listdir(rootdir)

for i in range(0,len(list)):
    path=rootdir+list[i]+"\\default_person.csv"
    #print(path)
    features_mean_default_person[i] = pd.read_csv(path)

# 计算两个向量间的欧式距离
def return_euclidean_distance(feature_1, feature_2):
    feature_1 = np.array(feature_1)
    feature_2 = np.array(feature_2)
    dist = np.sqrt(np.sum(np.square(feature_1 - feature_2)))
    #print(dist)

    if dist > 0.5:
        return "diff"
    else:
        return "same"
# dlib预测器
detector = dlib.get_frontal_face_detector()
predictor = dlib.shape_predictor(sys.argv[2]+'shape_predictor_68_face_landmarks.dat')
# 创建cv2摄像头对象
cap = cv2.VideoCapture(0)

# cap.set(propId, value)
# 设置视频参数，propId设置的视频参数，value设置的参数值
cap.set(3, 480)


def get_128d_features(img_gray):
    dets = detector(img_gray, 1)
    if (len(dets) != 0):
        shape = predictor(img_gray, dets[0])
        face_descriptor = facerec.compute_face_descriptor(img_gray, shape)
    else:
        face_descriptor = 0
    return face_descriptor


# cap.isOpened（） 返回true/false 检查初始化是否成功
flag, im_rd = cap.read()
cv2.imshow("camera", im_rd)
while(cap.isOpened()):

    # cap.read()
    # 返回两个值：
    # 一个布尔值true/false，用来判断读取视频是否成功/是否到视频末尾
    # 图像对象，图像的三维矩阵
    flag, im_rd = cap.read()

    # 每帧数据延时1ms，延时为0读取的是静态帧
    kk = cv2.waitKey(3)

    # 取灰度
    img_gray = cv2.cvtColor(im_rd, cv2.COLOR_RGB2GRAY)

    # 人脸数rects
    rects = detector(img_gray, 0)

    # print(len(rects))

    # 待会要写的字体
    font = cv2.FONT_HERSHEY_SIMPLEX

    cv2.putText(im_rd, "q: quit", (20, 400), font, 0.8, (0, 255, 255), 1, cv2.LINE_AA)

    if (len(rects) != 0):
    # 检测到人脸
        #print("检测到人脸")
        # 将捕获到的人脸提取特征和内置特征进行比对
        features_rd = get_128d_features(im_rd)
        for i in range(0,len(features_mean_default_person)):
            #print(features_mean_default_person[i])
            compare = return_euclidean_distance(features_rd, features_mean_default_person[i])
            #print(compare)
            im_rd = cv2.putText(im_rd, compare.replace("same", "default_person"), (20, 350), font, 0.8, (0, 255, 255),1,cv2.LINE_AA)
            if (compare == "same"):
                #print("开门")
                #print("欢迎:"+list[i])
                print(list[i])
                exit()
        # 矩形框
        for k, d in enumerate(rects):

            # 绘制矩形框
            im_rd = cv2.rectangle(im_rd, tuple([d.left(), d.top()]), tuple([d.right(), d.bottom()]), (0, 255, 255), 2)

            cv2.putText(im_rd, "faces: " + str(len(rects)), (20, 50), font, 1, (0, 0, 255), 1, cv2.LINE_AA)

    else:
        # 没有检测到人脸
        cv2.putText(im_rd, "no face", (20, 50), font, 1, (0, 0, 255), 1, cv2.LINE_AA)

        # 按下q键退出
        if (kk == ord('q')):
            break

        # 窗口显示
        #cv2.imshow("camera", im_rd)

# 释放摄像头
cap.release()

# 删除建立的窗口
cv2.destroyAllWindows()