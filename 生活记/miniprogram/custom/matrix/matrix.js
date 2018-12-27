Component({
  lifetimes: {
    attached() {
      var width = wx.getSystemInfoSync().windowWidth / this.properties.matrixLen;
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
    // 这里定义了innerText属性，属性值可以在组件使用时指定
    matrixData: {
      type: Array,
      value: [],
      observer(newVal, oldVal, changedPath) {
        console.log(wx.getSystemInfoSync().windowWidth)

      }
    },
    matrixLen: {
      type: Number,
      value: 3,
      observer(newVal, oldVal, changedPath) {
        
        console.log(wx.getSystemInfoSync().windowWidth)
        
      }
    }
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