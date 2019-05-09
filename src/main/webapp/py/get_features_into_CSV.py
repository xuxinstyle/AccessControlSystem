# -*- coding: UTF-8 -*-
# return_128d_features() 获取某张图像的128d特征
# write_into_csv() 将某个文件夹中的图像读取特征兵写入csv
# compute_the_mean() 从csv中读取128d特征，并计算特征均值

import cv2
import os
import dlib
from skimage import io
#import skimage as io
import csv
import numpy as np
import pandas as pd
import sys
import codecs
from datashape import unicode

currrent_path = os.getcwd()
shape_predictor_68_face_landmarks = sys.argv[2]+"shape_predictor_68_face_landmarks.dat"
#shape_predictor_68_face_landmarks = "shape_predictor_68_face_landmarks.dat"

dlib_face_recognition_resnet_model_v1 = sys.argv[2]+"dlib_face_recognition_resnet_model_v1.dat"
#dlib_face_recognition_resnet_model_v1 = "dlib_face_recognition_resnet_model_v1.dat"
# detector to find the faces
detector = dlib.get_frontal_face_detector()

# shape predictor to find the face landmarks
#currrent_path+'\\'+

predictor = dlib.shape_predictor(shape_predictor_68_face_landmarks)

# face recognition model, the object maps human faces into 128D vectors
facerec = dlib.face_recognition_model_v1(dlib_face_recognition_resnet_model_v1)
path_pics = sys.argv[3]
#path_pics="I:\\AccessControlSystem\\src\\main\\webapp\\images\\xuxiaoxin\\"
path_csv = sys.argv[1] #"I:/csvs/00001_admin/"
#path_csv = "I:\\AccessControlSystem\\src\\main\\webapp\\csvs\\xuxiaoxin\\"
username = sys.argv[4]
#username = "xuxiaoxin"
path_csv = path_csv.encode("utf-8").decode("gbk")
path_pics = path_pics.encode("utf-8").decode("gbk")
print("into get_features_into.CSV.py")
print(path_csv)
print(path_pics)
# 返回单张图像的128D特征
def return_128d_features(path_img):

    img = io.imread(path_img)

    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
    dets = detector(img_gray, 1)

    if (len(dets) != 0):
        shape = predictor(img_gray, dets[0])
        face_descriptor = facerec.compute_face_descriptor(img_gray, shape)

    else:
        face_descriptor = 0
        print("no face")
    #print(face_descriptor)
    return face_descriptor

isexist1 = os.path.exists(path_csv)
if not isexist1:
    print("create files dir")
    os.makedirs(path_csv)
    print("create success")
#print(path_pics)
dir_pics = os.listdir(path_pics)
#lenth=len(dir_pics)
# i1=0
# #for imgfileName in dir_pics:
# print(dir_pics+"_"+str(i1))
# i1=i1+1
imgName = os.listdir(path_pics)
#print(imgName)
isexist = os.path.exists(path_csv)
#print(isexist)
# if not isexist:
#     print("文件夹不存在需要创建")
#     os.makedirs(path_csv)
#     print("文件夹创建成功")
   # print(path_csv + dir_pics+".csv")
   #  with open(path_csv + imgName+".csv", "w", newline="") as csvfile:
   #      writer = csv.writer(csvfile)
   #      for i in range(len(dir_pics+imgName)):
   #          # 调用return_128d_features()得到128d特征
   #          # print(path_pics+imgfileName + ""+ imgName[i])
   #          features_128d = return_128d_features(path_pics + imgName)
   #          # print(features_128d)
   #          # 遇到没有检测出人脸的图片跳过
   #          if features_128d == 0:
   #              print("no")
   #          else:
   #              writer.writerow(features_128d)


    #if (os.path.exists(path_csv + imgName+".csv")):
        #continue

with open(path_csv+username+".csv", "w", newline="") as csvfile:
    print("I will create csv:"+path_csv+username+".csv")
    writer = csv.writer(csvfile)
    for i in range(len(imgName)):
        # 调用return_128d_features()得到128d特征
        #print(path_pics+imgfileName + ""+ imgName[i])
        features_128d = return_128d_features(path_pics + imgName[i])
        # print(features_128d)
        # 遇到没有检测出人脸的图片跳过
        if features_128d == 0:
            print("no")
        else:
            writer.writerow(features_128d)
isexist=os.path.exists(path_csv+username+".csv")
print(path_csv+username+".csv "+str(isexist))