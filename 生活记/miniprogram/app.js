var date = require("utils/date.js");

App({
  onLaunch: function () {
    
    if (!wx.cloud) {
      console.error('请使用 2.2.3 或以上的基础库以使用云能力')
    } else {
      wx.cloud.init({
        traceUser: true,
      })
    }

  },
  Date: date,
  //全局变量
  globalData: {
    server_url: "http://wx.luozc.cn",
    openid: "",
    sessionkey: "",
    wechatUserInfo:{},
    //这里还可以加入其它需要的请求头，比如'x-requested-with': 'XMLHttpRequest'表示ajax提交，微信的请求时不会带上这个的
    header: { cookie: '' }
  }
})
