/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/layout'

const deptRouter = {
  path: '/dept',
  component: Layout,
  redirect: 'noRedirect',
  name: 'Dept',
  meta: {
    title: '部门管理',
    icon: 'chart'
  },
  children: [
    {
      path: 'list',
      component: () => import('@/views/dept/list'),
      name: 'DeptList',
      meta: { title: '部门列表', noCache: true }
    },
    {
      path: 'chart',
      component: () => import('@/views/dept/DeptChart'),
      name: 'DeptChart',
      meta: { title: '图标展示', noCache: true }
    }
  ]
}

export default deptRouter
