import Vue from 'vue'
import axios from 'axios'
import router from '@/router'
import qs from 'qs'
import merge from 'lodash/merge'
import { clearLoginInfo } from '@/utils'

import { Message } from 'element-ui'

// 请求超时时间，10s
const requestTimeOut = 10 * 1000
const success = 200
// 提示信息显示时长
const messageDuration = 5 * 1000

const http = axios.create({
  timeout: 1000 * 30,
  withCredentials: true,
  headers: {
    'Content-Type': 'application/json; charset=utf-8'
  }
})

/**
 * 请求拦截
 */
http.interceptors.request.use(config => {
  config.headers['token'] = Vue.cookie.get('token') // 请求头带上token
  config.headers['Authorization'] ='bearer '+Vue.cookie.get('Authorization') // 请求头带上token
  return config
}, error => {
  return Promise.reject(error)
})

/**
 * 响应拦截
 */
http.interceptors.response.use(response => {
  if (response.data && response.data.code === 401) { // 401, token失效
    clearLoginInfo()
    router.push({ name: 'login' })
  }
  return response
}, error => {
  if (error.response) {
    console.log("--------------------------------------");
    console.log(error.response)
    const errorMessage = error.response.data === null ? '系统内部异常，请联系网站管理员' : error.response.data.message
    switch (error.response.status) {
      case 404:
        Message({
          message: '很抱歉，资源未找到',
          type: 'error',
          duration: messageDuration
        })
        break
      case 403:
        Message({
          message: '很抱歉，您暂无该操作权限',
          type: 'error',
          duration: messageDuration
        })
        break
      case 401:
        Message({
          message: '很抱歉，平台认证已失效，请重新登录',
          type: 'error',
          duration: messageDuration
        })
        break
      default:
        if (errorMessage === 'refresh token无效') {
          MessageBox.alert('登录已过期，请重新登录', '温馨提示', {
            confirmButtonText: '确定',
            showClose: false,
            callback: action => {
              router.push('/login')
            }
          })
        } else {
          Message({
            message: errorMessage,
            type: 'error',
            duration: messageDuration
          })
        }
        break
    }
  }
  return Promise.reject(error)
})

/**
 * 请求地址处理
 * @param {*} actionName action方法名称
 */
http.adornUrl = (actionName) => {
  // 非生产环境 && 开启代理, 接口前缀统一使用[/proxyApi/]前缀做代理拦截!
  return (process.env.NODE_ENV !== 'production' && process.env.OPEN_PROXY ? '/proxyApi/' : window.SITE_CONFIG.baseUrl) + actionName
}

/**
 * get请求参数处理
 * @param {*} params 参数对象
 * @param {*} openDefultParams 是否开启默认参数?
 */
http.adornParams = (params = {}, openDefultParams = true) => {
  var defaults = {
    't': new Date().getTime()
  }
  return openDefultParams ? merge(defaults, params) : params
}

/**
 * post请求数据处理
 * @param {*} data 数据对象
 * @param {*} openDefultdata 是否开启默认数据?
 * @param {*} contentType 数据格式
 *  json: 'application/json; charset=utf-8'
 *  form: 'application/x-www-form-urlencoded; charset=utf-8'
 */
http.adornData = (data = {}, openDefultdata = true, contentType = 'json') => {
  var defaults = {
    't': new Date().getTime()
  }
  data = openDefultdata ? merge(defaults, data) : data
  return contentType === 'json' ? JSON.stringify(data) : qs.stringify(data)
}

export default http
