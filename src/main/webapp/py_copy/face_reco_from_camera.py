# 2018-5-11
# By TimeStamp
# cnblogs: http://www.cnblogs.com/AdaminXie

import dlib  # 人脸识别的库dlib
import numpy as np  # 数据处理的库numpy
import cv2  # 图像处理的库OpenCv
import csv
import os
import codecs
import pandas as pd
import sys
from PIL import Image
# face recognition model, the object maps human faces into 128D vectors
from datashape import unicode

facerec = dlib.face_recognition_model_v1(sys.argv[2]+"dlib_face_recognition_resnet_model_v1.dat")

#遍历csvs文件夹下的所有文件
#rootdir="I:/csvs/00001_admin/"
#rootdir="I:\\AccessControlSystem\\src\\main\\webapp\\csvs\\"
#rootdir="I:\\csvs\\"
#存放csv文件的路径
rootdir=sys.argv[1]
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
#cap = cv2.VideoCapture(0)

# cap.set(propId, value)
# 设置视频参数，propId设置的视频参数，value设置的参数值
#cap.set(3, 480)


def get_128d_features(img_gray):
    dets = detector(img_gray, 1)
    if (len(dets) != 0):
        shape = predictor(img_gray, dets[0])
        face_descriptor = facerec.compute_face_descriptor(img_gray, shape)
    else:
        face_descriptor = 0
    return face_descriptor


# cap.isOpened（） 返回true/false 检查初始化是否成功
ImagePath=sys.argv[3] #"I:\\images\\00001_admin\\img_face_2.jpg"
#im_rd = Image.open(ImagePath)
#Image._show(im_rd)
#im_rd = np.array(im_rd)
im_rd=cv2.imread(ImagePath)
    # 取灰度
img_gray = cv2.cvtColor(im_rd, cv2.COLOR_RGB2GRAY)

    # 人脸数rects
rects = detector(img_gray, 0)


if (len(rects) != 0):
# 检测到人脸
    #print("检测到人脸")
    # 将捕获到的人脸提取特征和内置特征进行比对
    features_rd = get_128d_features(im_rd)
    for i in range(0,len(features_mean_default_person)):
        compare = return_euclidean_distance(features_rd, features_mean_default_person[i])
        #print(compare)


        if (compare == "same"):
            #print("开门")
            #print("欢迎:"+list[i])
            print(list[i])
            exit()

else:
    # 没有检测到人脸
    print("failure")
