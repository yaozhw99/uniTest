import Vue from 'vue';
import VueRouter from "vue-router";

import Home from "../views/Home";
import About from "../views/About";
import Contract from "../views/Contract";
import NewsDetail from "../views/news/NewsDetail";
import NewsEdit from "../views/news/NewsEdit";
import NewsList from "../views/news/NewsList";
import UniTableDetail from "../components/UniTableDetail";
import index from "../layout/index";
import LayoutMain from "../layout/components/LayoutMain";
import NewsDetail2 from "../layout/components/NewsDetail";

//把vuerouter注入到vue实例
Vue.use(VueRouter)

export default new VueRouter({
  routes:[
    {path:'/home/:id',name:'home',component:Home},
    {path:'/about',component: About},
    {path:'/contract',name:'contract',component:Contract},
    {path:'/index',component:index},
    {path:'/detail',component:LayoutMain},
    {path:'/secone/:id',component:NewsDetail2},
    {path:'/tabledetail',name:'tabledetail',component:UniTableDetail},
    {
      path:'/news',
      component:NewsList,
      children:[
        {path:'edit',component: NewsEdit},
        {path:'detail',name:'detail',component:NewsDetail},
        {path:'/news/:id',component:NewsDetail}
      ]
    }
  ],
  mode:'history'
})
