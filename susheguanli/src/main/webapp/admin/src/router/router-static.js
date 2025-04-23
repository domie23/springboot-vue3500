import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import banzhuren from '@/views/modules/banzhuren/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import kuaidi from '@/views/modules/kuaidi/list'
    import laifang from '@/views/modules/laifang/list'
    import sushe from '@/views/modules/sushe/list'
    import susheBaoxiu from '@/views/modules/susheBaoxiu/list'
    import weisheng from '@/views/modules/weisheng/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import suguan from '@/views/modules/suguan/list'
    import dictionaryBanji from '@/views/modules/dictionaryBanji/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryKuaidi from '@/views/modules/dictionaryKuaidi/list'
    import dictionaryLoudong from '@/views/modules/dictionaryLoudong/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShifou from '@/views/modules/dictionaryShifou/list'
    import dictionarySusheBaoxiu from '@/views/modules/dictionarySusheBaoxiu/list'
    import dictionaryZhiwei from '@/views/modules/dictionaryZhiwei/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBanji',
        name: '班级类型名称',
        component: dictionaryBanji
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型名称',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryKuaidi',
        name: '快递公司类型名称',
        component: dictionaryKuaidi
    }
    ,{
        path: '/dictionaryLoudong',
        name: '楼栋类型名称',
        component: dictionaryLoudong
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型名称',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShifou',
        name: '是否同意',
        component: dictionaryShifou
    }
    ,{
        path: '/dictionarySusheBaoxiu',
        name: '报修状态',
        component: dictionarySusheBaoxiu
    }
    ,{
        path: '/dictionaryZhiwei',
        name: '职位类型名称',
        component: dictionaryZhiwei
    }


    ,{
        path: '/banzhuren',
        name: '班主任',
        component: banzhuren
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告信息',
        component: gonggao
      }
    ,{
        path: '/kuaidi',
        name: '快递',
        component: kuaidi
      }
    ,{
        path: '/laifang',
        name: '来访人员',
        component: laifang
      }
    ,{
        path: '/sushe',
        name: '宿舍',
        component: sushe
      }
    ,{
        path: '/susheBaoxiu',
        name: '宿舍报修',
        component: susheBaoxiu
      }
    ,{
        path: '/weisheng',
        name: '卫生',
        component: weisheng
      }
    ,{
        path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
    ,{
        path: '/suguan',
        name: '宿管',
        component: suguan
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
