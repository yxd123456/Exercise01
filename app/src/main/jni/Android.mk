LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE:= jni-test
LOCAL_SRC_FILES := HelloCpp.cpp, HelloC.c
include $(BUILD_SHARED_LIBRARY)
