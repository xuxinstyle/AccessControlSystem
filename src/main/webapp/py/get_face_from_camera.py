# -*- coding: UTF-8 -*-
import dlib  # 人脸识别的库dlib
import numpy as np  # 数据处理的库numpy
import cv2  # 图像处理的库OpenCv
import sys
import os
import codecs
# dlib预测器
detector = dlib.get_frontal_face_detector()
predictor = dlib.shape_predictor(sys.argv[2]+'shape_predictor_68_face_landmarks.dat')
#predictor = dlib.shape_predictor('shape_predictor_68_face_landmarks.dat')

# 创建cv2摄像头对象

cap = cv2.VideoCapture(0)

# cap.set(propId, value)
# 设置视频参数，propId设置的视频参数，value设置的参数值
cap.set(3, 480)

# 截图screenshoot的计数器
cnt_ss = 0

# 人脸截图的计数器
cnt_p = 0
currrent_path = os.getcwd()
# 保存
path_save = sys.argv[1]
#path_save=currrent_path
#path_save =path_save.encode("utf-8").decode("gbk")
print(path_save)
isexist = os.path.exists(path_save)
if not isexist:
    print("file is not exists")
    os.makedirs(path_save)
# cap.isOpened（） 返回true/false 检查初始化是否成功
while cap.isOpened():

    # cap.read()
    # 返回两个值：
    # 一个布尔值true/false，用来判断读取视频是否成功/是否到视频末尾
    # 图像对象，图像的三维矩阵q
    flag, im_rd = cap.read()

    # 每帧数据延时1ms，延时为0读取的是静态帧
    kk = cv2.waitKey(1)

    # 取灰度
    img_gray = cv2.cvtColor(im_rd, cv2.COLOR_RGB2GRAY)

    # 人脸数rects
    rects = detector(img_gray, 0)

    # print(len(rects))

    # 待会要写的字体
    font = cv2.FONT_HERSHEY_SIMPLEX

    if (len(rects) != 0):
     # 检测到人脸

     # 矩形框
     for k, d in enumerate(rects):

        # 计算矩形大小
        # (x,y), (宽度width, 高度height)
        pos_start = tuple([d.left(), d.top()])
        pos_end = tuple([d.right(), d.bottom()])

        # 计算矩形框大小
        height = d.bottom() - d.top()
        width = d.right() - d.left()

        # 根据人脸大小生成空的图像
        im_blank = np.zeros((height, width, 3), np.uint8)

        im_rd = cv2.rectangle(im_rd, tuple([d.left(), d.top()]), tuple([d.right(), d.bottom()]), (0, 255, 255), 2)
        im_blank = np.zeros((height, width, 3), np.uint8)

        # 保存人脸到本地
        if (kk == ord('s')):

            cnt_p += 1
            for ii in range(height):
                for jj in range(width):
                    im_blank[ii][jj] = im_rd[d.top() + ii][d.left() + jj]
            print(path_save + "\\img_face_" + str(cnt_p) + ".jpg")
            isexist = os.path.exists(path_save)
            if (not isexist):
                print("文件夹不存在需要创建")
                os.makedirs(path_save)
                print("文件夹创建成功")
                cv2.imwrite(path_save + "\\img_face_" + str(cnt_p) + ".jpg", im_blank)
                cv2.putText(im_rd, "faces: " + str(len(rects)), (20, 50), font, 1, (0, 0, 255), 1, cv2.LINE_AA)
            else:
                print("文件夹存在")
                cv2.imwrite(path_save + "\\img_face_" + str(cnt_p) + ".jpg",im_blank)
                cv2.putText(im_rd, "faces: " + str(len(rects)), (20, 50), font, 1, (0, 0, 255), 1, cv2.LINE_AA)
    else:
        # 没有检测到人脸
        cv2.putText(im_rd, "no face", (20, 50), font, 1, (0, 0, 255), 1, cv2.LINE_AA)

        # 添加说明
        im_rd = cv2.putText(im_rd, "s: save face", (20, 400), font, 0.8, (255, 255, 255), 1, cv2.LINE_AA)
        im_rd = cv2.putText(im_rd, "q: quit", (20, 450), font, 0.8, (255, 255, 255), 1, cv2.LINE_AA)

        # 按下q键退出
    if (kk == ord('q')):
        break

    # 窗口显示
    cv2.imshow("camera", im_rd)

# 释放摄像头
cap.release()

# 删除建立的窗口
cv2.destroyAllWindows()