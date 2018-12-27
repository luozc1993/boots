Component({
  lifetimes: {
    attached() {
      var width = wx.getSystemInfoSync().windowWidth / this.properties.matrixLen;
      //设置单元格宽高
      this.setData({
        width: width,
        height: width *0.8
      })

    },
    detached() {
      // 在组件实例被从页面节点树移除时执行
    },
  },
  properties: {
    // 数据列表
    matrixData: {
      type: Array,
      value: [],
      observer(newVal, oldVal, changedPath) {
        console.log(wx.getSystemInfoSync().windowWidth)

      }
    },
    //一行显示个数
    matrixLen: {  type: Number,value: 3},
    //值字体大小
    valueSize: {  type: String,value: "24px"},
    //标签字体大小
    lebalSize: {  type: String,value: "14px"},
    themeColor: { type: String, value:"#ffcf69"}
  },
  data: {
    // 这里是一些组件内部数据
    someData: {},
    width:"125",
    height:"125"
  },
  methods: {
    // 这里是一个自定义方法
    customMethod() { }
  }
})