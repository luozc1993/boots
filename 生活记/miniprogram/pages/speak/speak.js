var app = getApp();
var plugin = requirePlugin("WechatSI")
let manager = plugin.getRecordRecognitionManager()
const recorderManager = wx.getRecorderManager()
const innerAudioContext = wx.createInnerAudioContext()
Page({
  data:{
    wave: 'wave',
    tips: '点击开始录音'
  },
  formSubmit(e) {
    console.log('form发生了submit事件，携带数据为：', e.detail)
  },
  formReset() {
    console.log('form发生了reset事件')
  },
  speak() {
      if(this.data.wave == 'wave'){
          this.setData({
              wave: 'wave ripple',
              tips: '点击结束'
          })
        this.start();
      }else{
        this.setData({
          wave: 'wave',
          tips: '点击开始录音'
        })
        manager.stop();
        
      }
  },
  //开始录音的时候
  start: function () {
    // 开始识别语音，设置最长能录30s（插件默认最长能录60s，我觉得30s够了，反正也显示不完- -。）
   
    manager.onRecognize = function (res) {
      console.log("current result", res.result)
    }
    manager.onStop = function (res) {
      console.log("record file path", res.tempFilePath)
      console.log("result", res.result)
    }
    manager.onStart = function (res) {
      console.log("成功开始录音识别", res)
    }
    manager.onError = function (res) {
      console.error("error msg", res.msg)
    }
    manager.start({
      duration: 30000, lang: "zh_CN"
    })
  },
  //停止录音
  stop: function () {
    //语音识别停止（此时就会调用manager.onStop函数）
    manager.stop();
  }
})