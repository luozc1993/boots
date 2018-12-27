module.exports = {
  /**
   * 获取当前时间
   */
  getDate(){
    
    var date = new Date();
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let day = date.getDate();
    month = month > 9 ? month : '0' + month;;
    day = day > 9 ? day : '0' + day;
    this.getTime();
    return `${year}-${month}-${day}`;
  }, 
  /**
   * 获取时间
   */
  getTime() {
    var date = new Date();
    let hours = date.getHours();//小时
    let minutes = date.getMinutes();//分钟
    var seconds = date.getSeconds();//秒
    hours = hours > 9 ? hours : '0' + hours;
    minutes = minutes > 9 ? minutes : '0' + minutes;
    seconds = seconds > 9 ? seconds : '0' + seconds;
    return `${hours}:${minutes}`;
  },
  getDateTime(){
    return this.getDate()+" "+this.getTime();
  },
  /** 
 * 时间戳转化为年 月 日 时 分 秒 
 * number: 传入时间戳 
 * format：返回格式，支持自定义，但参数必须与formateArr里保持一致 
*/
  formatTimeTwo(number, format) {

  var formateArr = ['yyyy', 'MM', 'dd', 'HH', 'mm', 'ss'];
  var returnArr = [];

  var date = new Date(number);
  returnArr.push(date.getFullYear());
  returnArr.push(formatNumber(date.getMonth() + 1));
  returnArr.push(formatNumber(date.getDate()));

  returnArr.push(formatNumber(date.getHours()));
  returnArr.push(formatNumber(date.getMinutes()));
  returnArr.push(formatNumber(date.getSeconds()));

  for (var i in returnArr) {
    format = format.replace(formateArr[i], returnArr[i]);
  }
  return format;
}
}

function formatTime(date) {
  var year = date.getFullYear()
  var month = date.getMonth() + 1
  var day = date.getDate()

  var hour = date.getHours()
  var minute = date.getMinutes()
  var second = date.getSeconds()


  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

function formatNumber(n) {
  n = n.toString()
  return n[1] ? n : '0' + n
}


