var app = getApp();

module.exports = {
  wxlogin: wxlogin,
  addUserinfo: addUserinfo
}

function wxlogin(){
  wx.login({
    success(res) {
      if (res.code) {
        // 发起网络请求
        wx.request({
          url: app.globalData.server_url+'/wechat/wx511689066f0df42a/login',
          data: {
            code: res.code
          },
          success:function(res){
            if(res.data.status){
              var data = res.data.data;
              app.globalData.openid = data.openid;
              app.globalData.sessionkey = data.sessionkey;
              app.globalData.header = { Cookie:'JSESSIONID=' + data.sessionId};
              app.globalData.wechatUserInfo = data.wechatUserInfo;
            }
          }
        })
      } else {
        console.log('登录失败！' + res.errMsg)
      }
    }
  })
}
/**
 * 添加微信信息
 */
function addUserinfo(_this,userInfo){
  userInfo["openid"] = app.globalData.openid;
  if(app.globalData.wechatUserInfo==""){
    // 发起网络请求
    wx.request({
      url: app.globalData.server_url +'/wechat/wx511689066f0df42a/addUserinfo',
      data: userInfo,
      header:app.globalData.header,
      success: function (res) {
        if (res.data.status) {
          app.globalData.wechatUserInfo = res.data;
        }
      }
    })
  }
}