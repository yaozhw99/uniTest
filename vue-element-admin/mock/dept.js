import Mock from 'mockjs'

const List = []
const count = 50

for (let i = 0; i < count; i++) {
  List.push(Mock.mock({
    id: '@increment',
    deptName: '@title',
    'persons|5-20': 5
  }))
}

export default [
  {
    url: '/dept/list',
    type: 'get',
    response: config => {
      const { page = 1, limit = 20,deptName,type } = config.query
      let mockList = List.filter(item => {

        if (type==5 && item.persons>=5) return false
        if (type==10 && (item.persons<5 ||item.persons>=10)) return false
        if (type==30 && (item.persons<10 ||item.persons>=30)) return false
        if (type==31 && item.persons<30) return false

        if (deptName && item.deptName.indexOf(deptName)==-1) return false
        return true
      })

      const pageList = mockList.filter((item, index) => index < limit * page && index >= limit * (page - 1))

      return {
        code: 20000,
        data: {
          total: mockList.length,
          items: pageList
        }
      }
    }
  },
  {
    url: '/dept/delete',
    type: 'post',
    response: _ => {
      return {
        code: 20000,
        data: 'success'
      }
    }
  },
  {
    url: '/dept/create',
    type: 'post',
    response: _ => {
      return {
        code: 20000,
        data: 'success'
      }
    }
  },
  {
    url: '/dept/update',
    type: 'post',
    response: _ => {
      return {
        code: 20000,
        data: 'success'
      }
    }
  }
]

