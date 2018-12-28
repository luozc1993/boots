var app = getApp();
import Dialog from '../../dist/dialog/dialog';
import login from '../common/login.js';
import Notify from '../../dist/notify/notify';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    money:"",
    //分类
    types: [{ "name": '伙食费', "id": 1 }, { "name": '日常用品', "id": 2}, 
      { "name": '交通费用', "id": 3 }, { "name": '请客送礼', "id": 4}, 
      { "name": '医疗', "id": 5 }, { "name": '金融', "id": 6}, 
      { "name": "其他", "id": 7}],
    typeIndex:0,
    typeShow:false,
    dateTimeData:"",
    dateTimeStamp: new Date().getTime(),
    timeShow:false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    login.wxlogin();
    // Dialog.alert({
    //   message: '弹窗内容'  
    // }).then(() => {
    //   // on close
    // }); 
    this.setData({
      dateTimeData: app.Date.formatTimeTwo(new Date().getTime(), "yyyy-MM-dd HH:mm")
    });
    
  },
  moneyInput:function(e){
    console.log(e)
    this.setData({
      money: e.detail
    })
   
  },
  /**
   * 隐藏类型选择弹出层
   */
  onHideType:function(){
    this.setData({
      typeShow:false
    })
  },
  /**
   * 显示类型选择弹出层
   */
  onShowType:function(){
    this.setData({
      typeShow: true
    })
  },
  /**
   * 类型选择确定按钮
   */
  onConfirmType:function(e){
    this.setData({
      typeIndex: e.detail.index,
      typeShow: false
    })
  },



  /**
   * 隐藏类型选择弹出层
   */
  onHideTime: function () {
    this.setData({
      timeShow: false
    })
  },
  /**
   * 显示类型选择弹出层
   */
  onShowTime: function () {
    this.setData({
      timeShow: true
    })
  },
  /**
   * 时间改变按钮
   */
  onDateTimeChange(e) {
    this.setData({
      dateTimeData: app.Date.formatTimeTwo(e.detail.data.value, "yyyy-MM-dd HH:mm")
    });
  },
  /**
   * 时间确定按钮
   */
  onConfirmTime: function (e) {
    this.setData({
      timeShow: false, 
      dateTimeData: app.Date.formatTimeTwo(e.detail, "yyyy-MM-dd HH:mm")
    })
  },
  submit: function(e){
    //添加微信信息
    login.addUserinfo(this, e.detail.userInfo);

    var money = this.data.money;
    if (!money || money==0){
      Notify('金额不能为空');
      return false;
    }
    var type = this.data.types[this.data.typeIndex]['id'];
    var time = this.data.dateTimeStamp;
    // 发起网络请求
    wx.request({
      url: app.globalData.server_url + '/wechat/wx511689066f0df42a/addExpenditure',
      data: { "money": money, "type": type, "time": time,"openid":app.globalData.openid},
      header: app.globalData.header,
      success: function (res) {
        wx.navigateBack({
          delta: 1
        })
      }
    })
  }
})