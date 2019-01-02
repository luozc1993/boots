var app = getApp();
var plugin = requirePlugin("WechatSI");
let manager = plugin.getRecordRecognitionManager();
import login from '../common/login.js';
import Notify from '../../dist/notify/notify';
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
    typeName:"",
    money:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
   
    login.wxlogin();
    
  },
  onShow: function (options) {
    var _this = this;
    
    setTimeout(function () {
      _this.getSum();
      _this.onStop();
    }, 1000) //延迟时间 这里是1秒
    

    
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
      data: { "openid": app.globalData.openid},
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
      var value = res.result;
      console.log(value)
      var str = /\-\d\d*\.\d\d*|\-[1-9]\d*|\-[1-9]\d|[1-9]\d*/;
      var arr = value.match(str);
      if(!arr){
        Notify('内容格式错误:' + value);
      }else{
        var num = arr[0];
        that.setData({
          typeName: value.substr(0, value.indexOf(num)),
          money: num
        })
      }
    }
  },
  submit:function(e){
    var that = this;
    var type = e.target.dataset.type;
    var typeName = this.data.typeName;
    var money = this.data.money;
    // 发起网络请求
    wx.request({
      url: app.globalData.server_url + '/wechat/wx511689066f0df42a/addBill',
      data: { "money": money, "type": type, "typeName": typeName, "openid":  app.globalData.openid },
      header: app.globalData.header,
      success: function (res) {
        that.setData({
          typeName: "",
          money:""
        })
        that.getSum();
      }
    })
  },
  typeNameChange:function(e){
    this.setData({
      typeName: e.detail
    })
  },
  moneyChange: function (e) {
    this.setData({
      money: e.detail
    })
  }
})