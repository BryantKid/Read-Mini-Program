// pages/posts/post-detail/post-detail.js
var postdata = require('../../../data/posts_data.js')
Page({
  collectchange: function(){
    const postid = this.data.postid
    var collectjson = wx.getStorageSync('collect')
    if (collectjson) {
      this.setData({ collectdata: !this.data.collectdata })
    }
    else{
      collectjson = {}
    }
    collectjson[postid] = this.data.collectdata
    wx.setStorageSync('collect', collectjson);
    wx.showToast({
      title: this.data.collectdata? '已收藏':'取消收藏',
    })
  },
  /**
   * 页面的初始数据
   */
  data: {
    collectdata: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const postid = options.id
    this.data.postid = options.id
    const postlist = postdata.postlist
    this.setData({ ...postlist[postid]})
    if (wx.getStorageSync('collect')[postid]){
      this.setData({ collectdata: true })
    }
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

  }
})