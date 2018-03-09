//
// Created by dugaolong on 18/1/29.
//

#include <www_dgl_com_androidfive_JniUtils.h>

JNIEXPORT jstring JNICALL Java_www_dgl_com_androidfive_JniUtils_getThreeDesKey(JNIEnv *env, jobject obj){
    return (*env)->NewStringUTF(env, "123xxtqtone@lx100$#365#$");
}
JNIEXPORT jstring JNICALL Java_www_dgl_com_androidfive_JniUtils_getSqlKey(JNIEnv *env, jobject obj){
    return (*env)->NewStringUTF(env, "quantonghejiaoyu");
}