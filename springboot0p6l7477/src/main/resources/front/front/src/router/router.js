import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import AddrList from '../pages/shop-address/list'
import AddrAdd from '../pages/shop-address/addOrUpdate'
import Order from '../pages/shop-order/list'
import OrderConfirm from '../pages/shop-order/confirm'
import Cart from '../pages/shop-cart/list'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import shangjiaList from '../pages/shangjia/list'
import shangjiaDetail from '../pages/shangjia/detail'
import shangjiaAdd from '../pages/shangjia/add'
import meizhuangfenleiList from '../pages/meizhuangfenlei/list'
import meizhuangfenleiDetail from '../pages/meizhuangfenlei/detail'
import meizhuangfenleiAdd from '../pages/meizhuangfenlei/add'
import mianshuishangpinList from '../pages/mianshuishangpin/list'
import mianshuishangpinDetail from '../pages/mianshuishangpin/detail'
import mianshuishangpinAdd from '../pages/mianshuishangpin/add'
import tongzhigonggaoList from '../pages/tongzhigonggao/list'
import tongzhigonggaoDetail from '../pages/tongzhigonggao/detail'
import tongzhigonggaoAdd from '../pages/tongzhigonggao/add'
import zixunshangjiaList from '../pages/zixunshangjia/list'
import zixunshangjiaDetail from '../pages/zixunshangjia/detail'
import zixunshangjiaAdd from '../pages/zixunshangjia/add'
import friendlinkList from '../pages/friendlink/list'
import friendlinkDetail from '../pages/friendlink/detail'
import friendlinkAdd from '../pages/friendlink/add'
import onlinemessageList from '../pages/onlinemessage/list'
import onlinemessageDetail from '../pages/onlinemessage/detail'
import onlinemessageAdd from '../pages/onlinemessage/add'
import discussmianshuishangpinList from '../pages/discussmianshuishangpin/list'
import discussmianshuishangpinDetail from '../pages/discussmianshuishangpin/detail'
import discussmianshuishangpinAdd from '../pages/discussmianshuishangpin/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
                {
                    path: 'shop-address/list',
                    component: AddrList
                },
                {
                    path: 'shop-address/addOrUpdate',
                    component: AddrAdd
                },
				{
					path: 'shop-order/order',
					component: Order
				},
				{
					path: 'cart',
					component: Cart
				},
				{
					path: 'shop-order/orderConfirm',
					component: OrderConfirm
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'shangjia',
					component: shangjiaList
				},
				{
					path: 'shangjiaDetail',
					component: shangjiaDetail
				},
				{
					path: 'shangjiaAdd',
					component: shangjiaAdd
				},
				{
					path: 'meizhuangfenlei',
					component: meizhuangfenleiList
				},
				{
					path: 'meizhuangfenleiDetail',
					component: meizhuangfenleiDetail
				},
				{
					path: 'meizhuangfenleiAdd',
					component: meizhuangfenleiAdd
				},
				{
					path: 'mianshuishangpin',
					component: mianshuishangpinList
				},
				{
					path: 'mianshuishangpinDetail',
					component: mianshuishangpinDetail
				},
				{
					path: 'mianshuishangpinAdd',
					component: mianshuishangpinAdd
				},
				{
					path: 'tongzhigonggao',
					component: tongzhigonggaoList
				},
				{
					path: 'tongzhigonggaoDetail',
					component: tongzhigonggaoDetail
				},
				{
					path: 'tongzhigonggaoAdd',
					component: tongzhigonggaoAdd
				},
				{
					path: 'zixunshangjia',
					component: zixunshangjiaList
				},
				{
					path: 'zixunshangjiaDetail',
					component: zixunshangjiaDetail
				},
				{
					path: 'zixunshangjiaAdd',
					component: zixunshangjiaAdd
				},
				{
					path: 'friendlink',
					component: friendlinkList
				},
				{
					path: 'friendlinkDetail',
					component: friendlinkDetail
				},
				{
					path: 'friendlinkAdd',
					component: friendlinkAdd
				},
				{
					path: 'onlinemessage',
					component: onlinemessageList
				},
				{
					path: 'onlinemessageDetail',
					component: onlinemessageDetail
				},
				{
					path: 'onlinemessageAdd',
					component: onlinemessageAdd
				},
				{
					path: 'discussmianshuishangpin',
					component: discussmianshuishangpinList
				},
				{
					path: 'discussmianshuishangpinDetail',
					component: discussmianshuishangpinDetail
				},
				{
					path: 'discussmianshuishangpinAdd',
					component: discussmianshuishangpinAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
