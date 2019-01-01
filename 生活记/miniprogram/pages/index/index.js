var app = getApp();
var plugin = requirePlugin("WechatSI")
let manager = plugin.getRecordRecognitionManager()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    matrixData: [
      { "lebal": "收入", "value": "0","color":"red"}, 
      { "lebal": "支出", "value": "0","color":"green" }
    ],
    wave:"wave",
    value:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this;
    this.getSum();
   this.onStop();
  },
  onShow: function (options) {
   
  },
  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    this.getSum();
  },
  getSum:function(){
    var _this = this;
    wx.request({
      url: app.globalData.server_url + '/wechat/wx511689066f0df42a/getSum',
      header: app.globalData.header,
      success: function (res) {
        if (res.data.status) {
          var matrixData = [
            { "lebal": "收入", "value": res.data.data.Income, "color": "red" },
            { "lebal": "支出", "value": res.data.data.Expenditure, "color": "green" }
          ]
          _this.setData({
            matrixData: matrixData
          })
        }
      },
      complete: function () {
        // complete
        wx.hideNavigationBarLoading() //完成停止加载
        wx.stopPullDownRefresh() //停止下拉刷新
      }
    })
  },

  longpress:function(){
    this.setData({
      wave:"wave ripple"
    })
    manager.start({
      duration: 30000, lang: "zh_CN"
    })
  },
  touchend:function(){
    manager.stop();
    this.setData({
      wave: "wave"
    })
  },
  onStop:function(){
    var that = this;
    manager.onStop = function (res) {
      console.log(res)
      that.setData({
        value: res.result
      })
    }
  }
})