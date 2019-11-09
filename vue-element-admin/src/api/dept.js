import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: 'http://localhost:8080/dept/list',
    method: 'get',
    params: query
  })
}

export function fetchDept(id) {
  return request({
    url: 'http://localhost:8080/dept/detail',
    method: 'get',
    params: { id }
  })
}

export function createDept(data) {
  return request({
    url: 'http://localhost:8080/dept/create',
    method: 'post',
    data
  })
}

export function updateDept(data) {
  return request({
    url: 'http://localhost:8080/dept/update',
    method: 'post',
    data
  })
}

export function delDept(data) {
  return request({
    url: 'http://localhost:8080/dept/delete',
    method: 'post',
    data
  })
}
