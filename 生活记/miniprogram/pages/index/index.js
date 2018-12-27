var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    matrixData: [
      { "lebal": "收入", "value": "100","color":"red"}, 
      { "lebal": "支出", "value": "120","color":"green" }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this;
    wx.request({
      url: app.globalData.server_url + '/wechat/wx511689066f0df42a/getSum',
      header: app.globalData.header,
      success: function (res) {
        if (res.data.status) {
         var matrixData = [
           { "lebal": "收入", "value": res.data.data, "color": "red" },
            { "lebal": "支出", "value": "120", "color": "green" }
          ]
          _this.setData({
            matrixData: matrixData
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  expenditure:function(){
    wx.navigateTo({
      url:"../expenditure/expenditure"
    })
  }
})