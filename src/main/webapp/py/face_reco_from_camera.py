# 2018-5-11
# By TimeStamp
# cnblogs: http://www.cnblogs.com/AdaminXie

import dlib  # 人脸识别的库dlib
import numpy as np  # 数据处理的库numpy
import cv2  # 图像处理的库OpenCv
import csv
import os
import pandas as pd
# face recognition model, the object maps human faces into 128D vectors

facerec = dlib.face_recognition_model_v1("I:/Graduation_Project/face/test/dlib_face_recognition_resnet_model_v1.dat")

#遍历csvs文件夹下的所有文件
rootdir="I:/csvs/00001_admin/"
list=os.listdir(rootdir)
features_mean_default_person=os.listdir(rootdir)
for i in range(0,len(list)):
    path=os.path.join(rootdir,list[i])
    if os.path.isfile(path):
        features_mean_default_person[i] = pd.read_csv(path)

# 计算两个向量间的欧式距离
def return_euclidean_distance(feature_1, feature_2):
    feature_1 = np.array(feature_1)
    feature_2 = np.array(feature_2)
    dist = np.sqrt(np.sum(np.square(feature_1 - feature_2)))
    print(dist)

    if dist > 0.5:
        return "diff"
    else:
        return "same"


# file_path="I:/csvs/default_person.csv"
# #data = csv.reader(open(file_path))
# features_mean_default_person=pd.read_csv(file_path)
#print(data)
#
# features_mean_default_person = [-0.030892765492592986, 0.13333227054068916, 0.054221574805284799, -0.050820438289328626,
#                                 -0.056331159841073189, 0.0039378538311116004, -0.044465327145237675,
#                                 -0.13096490031794497, 0.14215188983239627, -0.084465635842398593, 0.34389359700052363,
#                                 -0.062936659118062566, -0.24372901571424385, -0.13270603316394905, -0.0472818422866495,
#                                 0.15475224742763921, -0.24415240554433121, -0.11213862150907516, 0.032288033417180964,
#                                 0.023676671577911628, 0.098508275653186594, -0.010117797634417289,
#                                 0.0048202000815715448, -0.014808513420192819, -0.060100053486071135,
#                                 -0.34934839135722112, -0.095795629448012301, -0.050788544706608117,
#                                 0.032316677762489567, -0.099673464894294739, -0.080181991975558434,
#                                 0.096361607705291952, -0.1823408101734362, -0.045472671817007815,
#                                 -0.0066827326326778062, 0.047393877549391041, -0.038414973079373964,
#                                 -0.039067085930391363, 0.15961966781239761, 0.0092458106136243598, -0.16182226570029007,
#                                 0.026322136191945327, -0.0039144184832510193, 0.2492692768573761, 0.19180528427425184,
#                                 0.022950534855848866, -0.019220497949342979, -0.15331173021542399, 0.047744840089427795,
#                                 -0.17038608616904208, 0.026140184680882254, 0.19366614363695445, 0.066497623724372762,
#                                 0.07038829416820877, -0.0549700813073861, -0.11961311768544347, -0.032121153940495695,
#                                 0.083507449611237169, -0.14934051350543373, 0.011458799806668571, 0.10686114273573223,
#                                 -0.10744074888919529, -0.04377919611962218, -0.11030520381111848, 0.20804878441910996,
#                                 0.093076545941202266, -0.11621182490336268, -0.1991656830436305, 0.10751579348978244,
#                                 -0.11251544991606161, -0.12237925866716787, 0.058218707869711672, -0.15829276019021085,
#                                 -0.17670038891466042, -0.2718416170070046, 0.034569320955166689, 0.30443575821424784,
#                                 0.061833358712886512, -0.19622498672259481, 0.011373612000361868, -0.050225612756453063,
#                                 -0.036157087079788507, 0.12961127491373764, 0.13962576616751521, -0.0074232793168017737,
#                                 0.020964263007044792, -0.11185114399382942, 0.012502493042694894, 0.17834208513561048,
#                                 -0.072658227462517586, -0.041312719401168194, 0.25095899873658228,
#                                 -0.056628625839948654, 0.10285118379090961, 0.046701753217923012, 0.042323612264896691,
#                                 0.0036216247826814651, 0.066720707440062574, -0.16388990533979317, -0.0193739396421925,
#                                 0.027835704435251261, -0.086023958105789985, -0.05472404568603164, 0.14802298341926776,
#                                 -0.10644183582381199, 0.098863413851512108, 0.00061285014778963834,
#                                 0.062096107555063146, 0.051960245755157973, -0.099548895108072383,
#                                 -0.058173993112225285, -0.065454461562790375, 0.14721672511414477, -0.25363486848379435,
#                                 0.20384312381869868, 0.16890435312923632, 0.097537552447695477, 0.087824966562421697,
#                                 0.091438713434495431, 0.093809676797766431, -0.034379941362299417,
#                                 -0.085149037210564868, -0.24900743130006289, 0.021165960517368819, 0.076710369830068792,
#                                 -0.0061752907196549996, 0.028413473285342519, -0.029983982541843465]
#
# dlib预测器
detector = dlib.get_frontal_face_detector()
predictor = dlib.shape_predictor('shape_predictor_68_face_landmarks.dat')

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
        print("检测到人脸")
        # 将捕获到的人脸提取特征和内置特征进行比对
        features_rd = get_128d_features(im_rd)
        for i in range(0,len(features_mean_default_person)):
            print(features_mean_default_person[i])
            compare = return_euclidean_distance(features_rd, features_mean_default_person[i])
            print(compare)
            im_rd = cv2.putText(im_rd, compare.replace("same", "default_person"), (20, 350), font, 0.8, (0, 255, 255),1,cv2.LINE_AA)
            if (compare == "same"):
                print("开门")
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