<template>
  <div>
    <h2>宠物狗语音情绪识别</h2>

    <van-steps :active="step">
      <van-step>开始</van-step>
      <van-step>录入文件</van-step>
      <van-step>端点检测</van-step>
      <van-step>提取MFCC</van-step>
      <van-step>识别结果</van-step>
    </van-steps>

    <!-- 每个元素的两侧间隔相等 -->
    <van-row type="flex" justify="space-around">
      <van-col span="6">
        <!-- <label for>音频采集</label>
        <br /> -->
        <div v-if="recording">
          <van-loading size="24px" vertical type="spinner" color="#1989fa">录音中...</van-loading>
          <van-button type="danger" @click="stopRecord">停止录音</van-button>
        </div>
        <div v-else>
          <van-button type="info" @click="startRecord">开始录音</van-button>
        </div>
      </van-col>
      <van-col span="6">
        <div class="record">
		      <div class="record-play" v-show="isFinished">
			      <audio controls></audio>
		      </div>
	      </div>

        <div v-if="voice">
          <van-image src="../static/yuyinbo.jpg" />
          <p>文件载入成功</p>
        </div>
      </van-col>
    </van-row>

    <van-divider
      :style="{ color: '#1989fa', borderColor: '#1989fa', padding: '0 16px' }"
    ></van-divider>
    <br />
    <br />

    <van-row type="flex" justify="space-around">
      <van-col span="6">
        <van-button type="info" @click="handleClickForEndpoint"
          >端点检测</van-button
        >
      </van-col>
      <van-col span="6">
        <div v-if="endpoint">
          <van-image src="../static/1.jpg" />
        </div>
      </van-col>
    </van-row>

    <van-divider
      :style="{ color: '#1989fa', borderColor: '#1989fa', padding: '0 16px' }"
    ></van-divider>
    <br />
    <br />

    <van-row type="flex" justify="space-around">
      <van-col span="6">
        <van-button type="info" @click="handleClickForMfcc"
          >提取MFCC</van-button
        >
      </van-col>
      <van-col span="6">
        <div v-if="mfcc">
          <h3>提取MFCC成功！</h3>
        </div>
      </van-col>
    </van-row>

    <van-divider
      :style="{ color: '#1989fa', borderColor: '#1989fa', padding: '0 16px' }"
    ></van-divider>
    <br />
    <br />

    <van-row type="flex" justify="space-around">
      <van-col span="6">
        <van-button type="info" @click="handleClickForResult">识别</van-button>
      </van-col>
      <van-col span="6">
        <div v-if="result">
          <h3>本次识别结果: 高兴!</h3>
        </div>
      </van-col>
    </van-row>

    <van-steps :active="step">
        <van-step>开始</van-step>
      <van-step>录入文件</van-step>
      <van-step>端点检测</van-step>
      <van-step>提取MFCC</van-step>
      <van-step>识别结果</van-step>
    </van-steps>

    <!-- <van-tabbar v-model="active">
      <van-tabbar-item name="home" icon="home-o">标签</van-tabbar-item>
      <van-tabbar-item name="search" icon="search">标签</van-tabbar-item>
      <van-tabbar-item name="friends" icon="friends-o">标签</van-tabbar-item>
      <van-tabbar-item name="setting" icon="setting-o">标签</van-tabbar-item>
    </van-tabbar> -->
  </div>
</template>

<script>
import Vue from "vue";
import "vant/lib/index.css";

import { Button } from "vant";
import { Grid, GridItem } from "vant";
import { Row, Col } from "vant";
import { Image } from "vant";
import { Divider } from "vant";
import { Tabbar, TabbarItem } from "vant";
import { Step, Steps } from "vant";
import Record from "../js/record-sdk";
import { Loading } from 'vant';

Vue.use(Loading);
Vue.use(Step).use(Steps);
Vue.use(Tabbar).use(TabbarItem);
Vue.use(Divider);
Vue.use(Image);
Vue.use(Row).use(Col);
Vue.use(Grid).use(GridItem);
Vue.use(Button);

export default {
  data: function() {
    return {
      voice: false,
      endpoint: false,
      mfcc: false,
      result: false,
      active: "home",
      step: 0,
      isFinished: false,
			audio: "",
      recorder: new Record(),
      recording: false
    };
  },
  methods: {
    handleClickForVoice: function() {
      this.voice = true;
      this.step = 1;
    },
    handleClickForEndpoint: function() {
      this.endpoint = true;
      this.step = 2;
    },
    handleClickForMfcc: function() {
      this.mfcc = true;
      this.step = 3;
    },
    handleClickForResult: function() {
      this.result = true;
      this.step = 4;
    },
    startRecord: function() {
				console.log("start to record now.");
				let self = this;
        self.recording = true;
				self.recorder.startRecord({
					success: res => {
						console.log("start record successfully.");
					},
					error: res => {
						console.log("start record failed.");
					}
				});
			},
			stopRecord: function() {
				console.log("stop record now.");
				let self = this;
				//self.isFinished = false;
				self.recorder.stopRecord({
					success: res => {
						//此处可以获取音频源文件(res)，用于上传等操作
						self.isFinished = true;
            self.audio = document.querySelector("audio");
            self.recorder.play(self.audio);
            self.recording = false;
            this.step = 1;
						//self.audio.src = window.URL.createObjectURL(res);
						console.log("stop record successfully.");
					},
					error: res => {
						console.log("stop record failed.");
					}
				});
			},
			play: function() {
				console.log("play record now.");
				let self = this;
				self.isFinished = true;
				self.audio = document.querySelector("audio");
				self.recorder.play(self.audio);
			}
  }
};
</script>

<style scoped>
.record-play {
		width: 50%;
	}
</style>
