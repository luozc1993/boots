var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    matrixData: [
      { "lebal": "收入", "value": "0","color":"red"}, 
      { "lebal": "支出", "value": "0","color":"green" }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getSum();
  },
  onShow: function (options) {
    this.getSum();
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
            { "lebal": "收入", "value": 0, "color": "red" },
            { "lebal": "支出", "value": res.data.data, "color": "green" }
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