<template>
	<div class="menu-preview">
		<!-- 竖向-2 -->
		<el-scrollbar :wrap-class="isCollapse ? 'scrollbar-wrapper scrollbar-wrapper-close' : 'scrollbar-wrapper scrollbar-wrapper-open'">
		  <el-button :style="verticalStyle2[isCollapse?'close':'open'].btn.default" type="primary" @click="collapse">
		    <span class="icon iconfont"
		      :style="verticalStyle2[isCollapse?'close':'open'].btn.icon.default"
		      :class="verticalStyle2[isCollapse?'close':'open'].btn.icon.text"></span>{{verticalStyle2[isCollapse?'close':'open'].btn.text}}
		  </el-button>
		  <div class="userinfo"
		    :style="verticalStyle2[isCollapse?'close':'open'].userinfo.box.default">
		    <el-image v-if="avatar" :style="verticalStyle2[isCollapse?'close':'open'].userinfo.img.default" :src="avatar?this.$base.url + avatar:require('@/assets/img/avator.png')" fit="cover"></el-image>
		    <div :style="verticalStyle2[isCollapse?'close':'open'].userinfo.nickname.default">
		      {{this.$storage.get('adminName')}}</div>
		  </div>
		  <el-menu :default-active="activeMenu" :unique-opened="true" :style="verticalStyle2[isCollapse?'close':'open'].menu.box.default"
		    class="el-menu-vertical-2" :collapse-transition="false" :collapse="isCollapse">
		    <el-menu-item class="home" :popper-append-to-body="false" popper-class="home" @click.native="menuHandler('')" :style="verticalStyle2[isCollapse?'close':'open'].home.one.box.default" index="/">
		      <div class="el-tooltip">
		        <i :style="verticalStyle2[isCollapse?'close':'open'].home.one.icon.default"
		          class="icon iconfont icon-shouye-zhihui"></i>
		        <span :style="verticalStyle2[isCollapse?'close':'open'].home.one.title.default"
		          slot="title">{{verticalStyle2.open.home.one.title.text}}</span>
		      </div>
		    </el-menu-item>
		    <el-submenu class="user" popper-class="user" :popper-append-to-body="false"
		      :style="verticalStyle2[isCollapse?'close':'open'].user.one.box.default" index="1">
		      <template slot="title">
		        <i :style="verticalStyle2[isCollapse?'close':'open'].user.one.icon.default"
		          class="icon iconfont icon-kuaijiezhifu"></i>
		        <span :style="verticalStyle2[isCollapse?'close':'open'].user.one.title.default"
		          slot="title">{{verticalStyle2.open.user.one.title.text}}</span>
		      </template>
		      <el-menu-item index="/updatePassword" @click="menuHandler('updatePassword')">修改密码</el-menu-item>
		      <el-menu-item index="/center" @click="menuHandler('center')">个人信息</el-menu-item>
		    </el-submenu>
			<template v-for="(menu,index) in menuList.backMenu">
				<el-submenu v-if="menu.child.length > 1 || !verticalIsMultiple" class="other" popper-class="other" :popper-append-to-body="false" :style="verticalStyle2[isCollapse?'close':'open'].menu.one.box.default" :index="index+2+''">
					<template slot="title">
						<i :style="verticalStyle2[isCollapse?'close':'open'].menu.one.icon.default" class="el-icon-menu" :class="icons[index]"></i>
						<span :style="verticalStyle2[isCollapse?'close':'open'].menu.one.title.default" slot="title">{{menu.menu + (verticalFlag ? '管理' : '')}}</span>
					</template>
					<el-menu-item v-for="(child,sort) in menu.child" :key="sort" :index="'/'+child.tableName" @click="menuHandler(child.tableName)">{{ child.menu }}</el-menu-item>
				</el-submenu>
				<el-menu-item v-if="menu.child.length <= 1 && verticalIsMultiple" class="other" popper-class="other" :style="verticalStyle2[isCollapse?'close':'open'].menu.one.box.default" @click="menuHandler(menu.child[0].tableName)" :index="'/'+menu.child[0].tableName">
				  <div class="el-tooltip">
				    <i :style="verticalStyle2[isCollapse?'close':'open'].menu.one.icon.default" class="el-icon-menu" :class="icons[index]"></i>
				    <span :style="verticalStyle2[isCollapse?'close':'open'].menu.one.title.default" slot="title">{{menu.child[0].menu + (verticalFlag ? '管理' : '')}}</span>
				  </div>
				</el-menu-item>
			</template>
		  </el-menu>
		</el-scrollbar>


	</div>
</template>

<script>
import menu from '@/utils/menu'
export default {
	data() {
		return {
			menuList: [],
			dynamicMenuRoutes: [],
			role: '',
			user: null,
			avatar:'',
			icons: [
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-fold',
				'el-icon-s-unfold',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-custom',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check',
				'el-icon-s-grid',
				'el-icon-menu',
				'el-icon-chat-dot-square',
				'el-icon-message',
				'el-icon-postcard',
				'el-icon-position',
				'el-icon-microphone',
				'el-icon-close-notification',
				'el-icon-bangzhu',
				'el-icon-time',
				'el-icon-odometer',
				'el-icon-crop',
				'el-icon-aim',
				'el-icon-switch-button',
				'el-icon-full-screen',
				'el-icon-copy-document',
				'el-icon-mic',
				'el-icon-stopwatch',
			],
			menulistBorderBottom: {},
			verticalFlag: false,
			isCollapse: false,
			verticalStyle2: {"isCollapse":false,"close":{"contentBox":{"hover":{},"active":{"margin":"0 0 0 54px"},"default":{"minHeight":"100%","padding":"0","margin":"0 0 0 64px","position":"relative","display":"block"}},"box":{"hover":{},"active":{"width":"54px"},"default":{"boxShadow":"0px 0 0px rgba(86,178,198,.3)","padding":"45px 4px 0 0","bottom":"0","transition":"width 0.3s","overflow":"hidden","top":"0","left":"0","background":"rgba(86,178,198,.5)","width":"64px","fontSize":"0px","position":"fixed","height":"100%","zIndex":"1001"}},"menu":{"two":{"title":{"hover":{"padding":"0 20px","backgroundColor":"rgba(86,178,198,.8) !important","lineHeight":"44px","color":"#fff","height":"44px"},"active":{"padding":"0 20px","backgroundColor":"rgba(86,178,198,.8) !important","lineHeight":"44px","color":"#fff","height":"44px"},"default":{"padding":"0 20px","backgroundColor":"#fff","lineHeight":"44px","fontSize":"14px","color":"#666","height":"44px"}},"box":{"hover":{},"default":{"border":"none","padding":"0","fontSize":"inherit"}}},"box":{"hover":{},"default":{"border":0,"padding":"0 4px","listStyle":"none","margin":"0 0px","alignItems":"flex-start","flexWrap":"wrap","background":"none","display":"flex","width":"100%","position":"relative"}},"one":{"box1":{"hover":{"color":"#fff","background":"rgba(86,178,198,.8)"},"active":{"color":"#fff","background":"rgba(86,178,198,.8)"},"default":{"cursor":"pointer","padding":"0 20px","whiteSpace":"nowrap","color":"#333","background":"#fff","fontSize":"inherit","position":"relative"}},"icon":{"hover":{},"default":{"verticalAlign":"middle","margin":"0","color":"inherit","textAlign":"center","display":"inline-block","width":"24px","fontSize":"18px"},"flag":true},"box":{"hover":{},"default":{"padding":"0","listStyle":"none","margin":"0","fontSize":"inherit"}},"title":{"hover":{},"default":{"width":"0","verticalAlign":"middle","fontSize":"inherit","color":"inherit","height":"0"}},"arrow":{"hover":{},"default":{"verticalAlign":"middle","margin":"-7px 0 0 0","top":"50%","color":"inherit","display":"none","fontSize":"12px","position":"absolute","right":"20px"}}}},"btn":{"icon":{"hover":{},"default":{"margin":"0 2px 0 0","fontSize":"14px","color":"#fff","height":"40px"},"text":"icon-gengduo1"},"hover":{"opacity":"0.8"},"default":{"border":"0","cursor":"pointer","padding":"0 4px","margin":"4px 4px 10px","color":"#fff","outline":"none","borderRadius":"8px","top":"0","left":"0","background":"rgba(86,178,198,.8)","width":"56px","fontSize":"14px","position":"fixed","height":"36px"},"text":"展开"},"user":{"two":{"title":{"hover":{"padding":"0 20px","backgroundColor":"red !important","lineHeight":"56px","color":"#fff","height":"56px"},"active":{"padding":"0 20px","backgroundColor":"blue !important","lineHeight":"56px","color":"#fff","height":"56px"},"default":{"padding":"0 20px","backgroundColor":"#fff","lineHeight":"56px","color":"#656","height":"56px"}},"box":{"hover":{},"default":{"border":"none"}}},"one":{"box1":{"hover":{"color":"#fff","background":"blue"},"active":{"color":"#fff","background":"blue"},"default":{"cursor":"pointer","padding":"0 20px","whiteSpace":"nowrap","position":"relative","color":"#323","background":"#fff"}},"icon":{"hover":{},"default":{"verticalAlign":"middle","margin":"0","color":"inherit","textAlign":"center","display":"inline-block","width":"24px","fontSize":"18px"},"flag":true,"text":"icon-kuaijiezhifu"},"box":{"hover":{},"default":{"padding":"0","listStyle":"none","margin":"0","order":"2"}},"title":{"hover":{},"default":{"width":"0","verticalAlign":"middle","fontSize":"14px","color":"inherit","height":"0"}},"arrow":{"hover":{},"default":{"verticalAlign":"middle","margin":"-7px 0 0 0","top":"50%","color":"inherit","display":"none","fontSize":"12px","position":"absolute","right":"20px"}}}},"userinfo":{"nickname":{"hover":{},"default":{"fontSize":"12px","lineHeight":"1.5","color":"#fff","textAlign":"center"}},"img":{"hover":{},"default":{"width":"100%","objectFit":"cover","borderRadius":"10px","display":"block","height":"40px"}},"box":{"hover":{},"default":{"width":"100%","padding":"4px","display":"none","height":"auto"}}},"home":{"two":{"title":{"hover":{"padding":"0 20px","backgroundColor":"red !important","lineHeight":"56px","color":"#fff","height":"56px"},"active":{"padding":"0 20px","backgroundColor":"blue !important","lineHeight":"56px","color":"#fff","height":"56px"},"default":{"padding":"0 20px","backgroundColor":"#fff","lineHeight":"56px","color":"#646","height":"56px"}},"box":{"hover":{},"default":{"border":"none"}}},"one":{"box1":{"hover":{"color":"#fff","background":"rgba(86,178,198,.8)"},"active":{"color":"#fff","background":"rgba(86,178,198,.8)"},"default":{"cursor":"pointer","padding":"0 20px","whiteSpace":"nowrap","position":"relative","color":"#fff","background":"rgba(86,178,198,.8)"}},"icon":{"hover":{},"default":{"verticalAlign":"middle","margin":"0","color":"inherit","textAlign":"center","display":"inline-block","width":"24px","fontSize":"18px"},"flag":true,"text":"icon-shouye-zhihui"},"box":{"hover":{},"default":{"padding":"0","listStyle":"none","margin":"0","clipPath":"polygon(10% 0, 90% 0, 100% 20%, 100% 100%, 0 100%, 0 20%)"}},"title":{"hover":{},"default":{"width":"0","verticalAlign":"middle","fontSize":"14px","color":"inherit","height":"0"}},"arrow":{"hover":{},"default":{"verticalAlign":"middle","margin":"-7px 0 0 0","top":"50%","color":"inherit","display":"none","fontSize":"12px","position":"absolute","right":"20px"}}}}},"open":{"contentBox":{"hover":{},"default":{"minHeight":"100%","padding":"0","margin":"0 0 0 210px","position":"relative","display":"block"}},"box":{"hover":{},"default":{"boxShadow":"0px 0 0px rgba(86,178,198,.3)","padding":"45px 0 0","bottom":"0","transition":"width 0.3s","overflow":"hidden","top":"0","left":"0","background":"rgba(86,178,198,.5)","width":"210px","fontSize":"16px","position":"fixed","height":"100%","zIndex":"1001"}},"menu":{"two":{"title":{"hover":{"padding":"0 40px","lineHeight":"50px","color":"#333","background":"rgba(86,178,198,.3)","height":"50px"},"active":{"padding":"0 40px","lineHeight":"50px","color":"#333","background":"rgba(86,178,198,.3)","height":"50px"},"default":{"padding":"0 40px","borderColor":"rgba(86,178,198,.1)","color":"#666","background":"none","borderWidth":"0 0 1px","lineHeight":"50px","fontSize":"inherit","borderStyle":"solid","height":"50px"}},"box":{"hover":{},"default":{"border":"none","background":"rgba(255,255,255,.8)","fontSize":"inherit"}}},"box":{"hover":{},"default":{"border":0,"padding":"0 6px","listStyle":"none","margin":"0","alignItems":"flex-start","flexWrap":"wrap","background":"none","display":"flex","position":"relative"}},"one":{"box1":{"hover":{"color":"#fff","background":"rgba(86,178,198,.8)"},"active":{"color":"#fff","background":"rgba(86,178,198,.8)"},"default":{"cursor":"pointer","padding":"0 20px","whiteSpace":"nowrap","color":"#333","background":"#fff","fontSize":"inherit","position":"relative"}},"icon":{"hover":{},"default":{"verticalAlign":"middle","margin":"0 3px","color":"inherit","textAlign":"center","display":"inline-block","width":"34px","fontSize":"inherit"},"flag":true},"box":{"hover":{},"default":{"width":"100%","padding":"0","listStyle":"none","margin":"0"}},"title":{"hover":{},"default":{"color":"inherit","verticalAlign":"middle","fontSize":"inherit"}},"arrow":{"hover":{},"default":{"verticalAlign":"middle","margin":"-7px 0 0 0","top":"50%","color":"inherit","fontSize":"inherit","position":"absolute","right":"20px"}}}},"btn":{"icon":{"hover":{},"default":{"margin":"0 2px","fontSize":"inherit","color":"#fff","height":"40px"},"text":"icon-guanbi1"},"hover":{"opacity":"0.8"},"default":{"border":"0","cursor":"pointer","padding":"0 8px 0 4px","margin":"4px 4px 0px","color":"#fff","outline":"none","borderRadius":"8px","top":"0","left":"0","background":"rgba(86,178,198,.8)","width":"auto","fontSize":"inherit","position":"fixed","height":"36px"},"text":"关闭"},"user":{"two":{"title":{"hover":{"padding":"0 40px","lineHeight":"50px","color":"#333","background":"rgba(86,178,198,.3)","height":"50px"},"active":{"padding":"0 40px","lineHeight":"50px","color":"#333","background":"rgba(86,178,198,.3)","height":"50px"},"default":{"padding":"0 40px","lineHeight":"50px","color":"#665","background":"none","height":"50px"}},"box":{"hover":{},"default":{"border":"none"}}},"one":{"box1":{"hover":{"color":"#fff","background":"rgba(86,178,198,.8)"},"active":{"color":"#fff","background":"rgba(86,178,198,.8)"},"default":{"cursor":"pointer","padding":"0 20px","whiteSpace":"nowrap","color":"#332","background":"#fff","fontSize":"inherit","position":"relative"}},"icon":{"hover":{},"default":{"verticalAlign":"middle","margin":"0 3px","color":"inherit","textAlign":"center","display":"inline-block","width":"34px","fontSize":"inherit"},"flag":true,"text":"icon-kuaijiezhifu"},"box":{"hover":{},"default":{"width":"100%","padding":"0","listStyle":"none","margin":"0","order":"2"}},"title":{"hover":{},"default":{"color":"inherit","verticalAlign":"middle","fontSize":"inherit"},"text":"个人资料"},"arrow":{"hover":{},"default":{"verticalAlign":"middle","margin":"-7px 0 0 0","top":"50%","color":"inherit","fontSize":"inherit","position":"absolute","right":"20px"}}}},"userinfo":{"nickname":{"hover":{},"default":{"fontSize":"24px","lineHeight":"1.5","color":"#fff","textAlign":"center"}},"img":{"hover":{},"default":{"width":"100%","objectFit":"cover","borderRadius":"8px","display":"block","height":"170px"}},"box":{"hover":{},"default":{"width":"100%","padding":"12px 12px 12px","height":"auto","order":"2"}}},"home":{"two":{"title":{"hover":{"padding":"0 40px","lineHeight":"50px","color":"#fff","background":"red","height":"50px"},"active":{"padding":"0 40px","lineHeight":"50px","color":"#fff","background":"blue","height":"50px"},"default":{"padding":"0 40px","lineHeight":"50px","color":"#664","background":"#fff","height":"50px"}},"box":{"hover":{},"default":{"border":"none","display":"none"}}},"one":{"box1":{"hover":{"color":"#fff","background":"rgba(86,178,198,.8)"},"active":{"color":"#fff","background":"rgba(86,178,198,.8)"},"default":{"cursor":"pointer","padding":"0 20px","whiteSpace":"nowrap","position":"relative","color":"#fff","background":"rgba(86,178,198,.8)"}},"icon":{"hover":{},"default":{"verticalAlign":"middle","margin":"0 3px","color":"inherit","textAlign":"center","display":"inline-block","width":"34px","fontSize":"inherit"},"flag":true,"text":"icon-shouye-zhihui"},"box":{"hover":{},"default":{"width":"100%","padding":"0","listStyle":"none","margin":"0","fontSize":"inherit","clipPath":"polygon(10% 0, 90% 0, 100% 20%, 100% 100%, 0 100%, 0 20%)"}},"title":{"hover":{},"default":{"color":"inherit","verticalAlign":"middle","fontSize":"inherit"},"text":"返回主页"},"arrow":{"hover":{},"default":{"verticalAlign":"middle","margin":"-7px 0 0 0","top":"50%","color":"inherit","fontSize":"12px","position":"absolute","right":"20px"}}}}}},
			verticalIsMultiple: true,
		}
	},
	computed: {
		activeMenu() {
			const route = this.$route
			console.log(route)
			const {
				meta,
				path
			} = route
			// if st path, the sidebar will highlight the path you sete
			if (meta.activeMenu) {
				return meta.activeMenu
			}
			return path
		}
	},
	watch:{
		avatar(){
			this.$forceUpdate()
		},
	},
	mounted() {
		const menus = menu.list()
		if(menus) {
			this.menuList = menus
		} else {
			let params = {
				page: 1,
				limit: 1,
				sort: 'id',
			}
			
			this.$http({
				url: "menu/list",
				method: "get",
				params: params
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					this.menuList = JSON.parse(data.data.list[0].menujson);
					this.$storage.set("menus", this.menuList);
				}
			})
		}
		this.role = this.$storage.get('role')
		
		for(let i=0;i<this.menuList.length;i++) {
			if(this.menuList[i].roleName == this.role) {
				this.menuList = this.menuList[i];
				break;
			}
		}
		this.styleChange()
		
		let sessionTable = this.$storage.get("sessionTable")
		this.$http({
			url: sessionTable + '/session',
			method: "get"
		}).then(({
			data
		}) => {
			if (data && data.code === 0) {
				if(sessionTable == 'yonghu') {
					this.avatar = data.data.touxiang
				}
				if(sessionTable == 'shangjia') {
					this.avatar = data.data.touxiang
				}
				if(sessionTable=='users') {
					this.avatar = data.data.image
				}
				this.user = data.data;
			} else {
				let message = this.$message
				message.error(data.msg);
			}
		});
	},
	created(){
		this.icons.sort(()=>{
			return (0.5-Math.random())
		})
	},
	methods: {
		collapse() {
		  this.isCollapse = !this.isCollapse
		  this.$emit('oncollapsechange', this.isCollapse)
		},
		styleChange() {
			this.$nextTick(() => {
								document.querySelectorAll('.el-menu-vertical-demo .el-submenu .el-menu').forEach(el => {
				  el.removeAttribute('style')
				  const icon = {"border":"none","display":"none"}
				  Object.keys(icon).forEach((key) => {
					el.style[key] = icon[key]
				  })
				})
											})
		},
		menuHandler(name) {
			let router = this.$router
			name = '/'+name
			router.push(name)
		},
	}
}
</script>
<style lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	
	    & /deep/ .scrollbar-wrapper {
	      overflow-x: hidden;
	    }
		
				// 竖向
		.el-menu-vertical-demo {
		  .el-submenu:first-of-type /deep/ .el-submenu__title .el-submenu__icon-arrow {
		    display: none;
		  }
		}
		
		.el-menu-vertical-demo>.el-menu-item {
				  				  cursor: pointer;
				  				  padding: 0 20px;
				  				  color: #333;
				  				  white-space: nowrap;
				  				  background: #fff;
				  				  position: relative;
				  		}
		
		.el-menu-vertical-demo>.el-menu-item:hover {
						color: #fff;
						background: blue;
					}
		
		.el-menu-vertical-demo .el-submenu /deep/ .el-submenu__title {
						cursor: pointer;
						padding: 0 20px;
						color: #333;
						white-space: nowrap;
						background: #fff;
						position: relative;
					}
		
		.el-menu-vertical-demo .el-submenu /deep/ .el-submenu__title:hover {
						color: #fff;
						background: blue;
					}
		
		.el-menu-vertical-demo .el-submenu /deep/ .el-submenu__title .el-submenu__icon-arrow {
						margin: -7px 0 0 0;
						top: 50%;
						color: inherit;
						vertical-align: middle;
						font-size: 12px;
						position: absolute;
						right: 20px;
					}
		
		.el-menu-vertical-demo .el-submenu {
						padding: 0;
						margin: 0;
						list-style: none;
					}
		
		// .el-menu-vertical-demo .el-submenu /deep/ .el-menu {
		// 				// 		border: none;
		// 				// 		display: none;
		// 				// }
		
		.el-menu-vertical-demo .el-submenu /deep/ .el-menu .el-menu-item {
						padding: 0 40px;
						color: #666;
						background: #fff;
						line-height: 50px;
						height: 50px;
					}
		
		.el-menu-vertical-demo .el-submenu /deep/ .el-menu .el-menu-item:hover {
						padding: 0 40px;
						color: #fff;
						background: red;
						line-height: 50px;
						height: 50px;
					}
		
		.el-menu-vertical-demo .el-submenu /deep/ .el-menu .el-menu-item.is-active {
						padding: 0 40px;
						color: #fff;
						background: blue;
						line-height: 50px;
						height: 50px;
					}
		// 竖向
			  }
	  	}
	// 竖向 样式二-open
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.other {
		font-size: inherit;
		background: none;
	}
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.home {
		font-size: inherit;
		background: none;
	}
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.other>.el-tooltip {
				cursor: pointer;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				background: #fff;
				font-size: inherit;
				position: relative;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.other>.el-tooltip:hover {
				color: #fff !important;
				background: rgba(86,178,198,.8) !important;
			}
	
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title {
				cursor: pointer !important;
				padding: 0 20px !important;
				color: #333 !important;
				white-space: nowrap !important;
				background: #fff !important;
				font-size: inherit !important;
				position: relative !important;
			}
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.other.is-active>.el-tooltip {
				color: #fff !important;
				background: rgba(86,178,198,.8) !important;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title:hover {
				color: #fff !important;
				background: rgba(86,178,198,.8) !important;
			}
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other.is-active /deep/ .el-submenu__title {
				color: #fff !important;
				background: rgba(86,178,198,.8) !important;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title .iconfont {
				margin: 0 3px;
				color: inherit;
				display: inline-block;
				vertical-align: middle;
				width: 34px;
				font-size: inherit;
				text-align: center;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title .el-submenu__icon-arrow {
				margin: -7px 0 0 0;
				top: 50%;
				color: inherit;
				vertical-align: middle;
				font-size: inherit;
				position: absolute;
				right: 20px;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 /deep/ .el-submenu.other .el-menu {
				border: none;
				background: rgba(255,255,255,.8);
				font-size: inherit;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other .el-menu .el-menu-item {
				padding: 0 40px !important;
				color: #666 !important;
				background: none !important;
				font-size: inherit !important;
				border-color: rgba(86,178,198,.1) !important;
				border-width: 0 0 1px !important;
				line-height: 50px !important;
				border-style: solid !important;
				height: 50px !important;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other .el-menu .el-menu-item:hover {
				padding: 0 40px !important;
				color: #333 !important;
				background: rgba(86,178,198,.3) !important;
				line-height: 50px !important;
				height: 50px !important;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other .el-menu .el-menu-item.is-active {
				padding: 0 40px !important;
				color: #333 !important;
				background: rgba(86,178,198,.3) !important;
				line-height: 50px !important;
				height: 50px !important;
			}

	// 竖向 样式二-close
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.other>.el-tooltip {
				cursor: pointer;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				background: #fff;
				font-size: inherit;
				position: relative;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.other>.el-tooltip:hover {
				color: #fff;
				background: rgba(86,178,198,.8);
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.other.is-active>.el-tooltip {
				color: #fff;
				background: rgba(86,178,198,.8);
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title {
				cursor: pointer !important;
				padding: 0 20px !important;
				color: #333 !important;
				white-space: nowrap !important;
				background: #fff !important;
				font-size: inherit !important;
				position: relative !important;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title:hover {
				color: #fff !important;
				background: rgba(86,178,198,.8) !important;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title .iconfont {
				margin: 0;
				color: inherit;
				display: inline-block;
				vertical-align: middle;
				width: 24px;
				font-size: 18px;
				text-align: center;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title .el-submenu__icon-arrow {
				margin: -7px 0 0 0;
				top: 50%;
				color: inherit;
				display: none;
				vertical-align: middle;
				font-size: 12px;
				position: absolute;
				right: 20px;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other .el-menu {
				border: none;
				padding: 0;
				font-size: inherit;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other .el-menu--vertical.other .el-menu-item {
				background-color: #fff;
				padding: 0 20px;
				color: #666;
				font-size: 14px;
				line-height: 44px;
				height: 44px;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other .el-menu--vertical.other .el-menu-item:hover {
				background-color: rgba(86,178,198,.8) !important;
				padding: 0 20px;
				color: #fff;
				line-height: 44px;
				height: 44px;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other .el-menu--vertical.other .el-menu-item.is-active {
				background-color: rgba(86,178,198,.8) !important;
				padding: 0 20px;
				color: #fff;
				line-height: 44px;
				height: 44px;
			}
	
	// 竖向 样式二-open-首页
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.home>.el-tooltip {
				cursor: pointer;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				background: #fff;
				font-size: inherit;
				position: relative;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.home>.el-tooltip:hover {
				color: #fff;
				background: rgba(86,178,198,.8);
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.home.is-active>.el-tooltip {
				color: #fff;
				background: rgba(86,178,198,.8);
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title {
				cursor: pointer !important;
				padding: 0 20px !important;
				color: #333 !important;
				white-space: nowrap !important;
				background: #fff !important;
				font-size: inherit !important;
				position: relative !important;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title:hover {
				color: #fff !important;
				background: rgba(86,178,198,.8) !important;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title .iconfont {
				margin: 0 3px;
				color: inherit;
				display: inline-block;
				vertical-align: middle;
				width: 34px;
				font-size: inherit;
				text-align: center;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title .el-submenu__icon-arrow {
				margin: -7px 0 0 0;
				top: 50%;
				color: inherit;
				vertical-align: middle;
				font-size: inherit;
				position: absolute;
				right: 20px;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home .el-menu {
				border: none;
				background: rgba(255,255,255,.8);
				font-size: inherit;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home .el-menu .el-menu-item {
				padding: 0 40px;
				color: #666;
				background: none;
				font-size: inherit;
				border-color: rgba(86,178,198,.1);
				border-width: 0 0 1px;
				line-height: 50px;
				border-style: solid;
				height: 50px;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home .el-menu .el-menu-item:hover {
				padding: 0 40px;
				color: #333;
				background: rgba(86,178,198,.3);
				line-height: 50px;
				height: 50px;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home .el-menu .el-menu-item.is-active {
				padding: 0 40px;
				color: #333;
				background: rgba(86,178,198,.3);
				line-height: 50px;
				height: 50px;
			}
	
	// 竖向 样式二-close-首页
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.home>.el-tooltip {
				cursor: pointer;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				background: #fff;
				font-size: inherit;
				position: relative;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.home>.el-tooltip:hover {
				color: #fff;
				background: rgba(86,178,198,.8);
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.home.is-active>.el-tooltip {
				color: #fff;
				background: rgba(86,178,198,.8);
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title {
				cursor: pointer;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				background: #fff;
				font-size: inherit;
				position: relative;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title:hover {
				color: #fff;
				background: rgba(86,178,198,.8);
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title .iconfont {
				margin: 0;
				color: inherit;
				display: inline-block;
				vertical-align: middle;
				width: 24px;
				font-size: 18px;
				text-align: center;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title .el-submenu__icon-arrow {
				margin: -7px 0 0 0;
				top: 50%;
				color: inherit;
				display: none;
				vertical-align: middle;
				font-size: 12px;
				position: absolute;
				right: 20px;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home .el-menu {
				border: none;
				padding: 0;
				font-size: inherit;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home .el-menu--vertical.home .el-menu-item {
				background-color: #fff;
				padding: 0 20px;
				color: #666;
				font-size: 14px;
				line-height: 44px;
				height: 44px;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home .el-menu--vertical.home .el-menu-item:hover {
				background-color: rgba(86,178,198,.8) !important;
				padding: 0 20px;
				color: #fff;
				line-height: 44px;
				height: 44px;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home .el-menu--vertical.home .el-menu-item.is-active {
				background-color: rgba(86,178,198,.8) !important;
				padding: 0 20px;
				color: #fff;
				line-height: 44px;
				height: 44px;
			}
	
	// 竖向 样式二-open-个人中心
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.user>.el-tooltip {
				cursor: pointer;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				background: #fff;
				font-size: inherit;
				position: relative;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.user>.el-tooltip:hover {
				color: #fff;
				background: rgba(86,178,198,.8);
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.user.is-active>.el-tooltip {
				color: #fff;
				background: rgba(86,178,198,.8);
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title {
				cursor: pointer !important;
				padding: 0 20px !important;
				color: #333 !important;
				white-space: nowrap !important;
				background: #fff !important;
				font-size: inherit !important;
				position: relative !important;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title:hover {
				color: #fff !important;
				background: rgba(86,178,198,.8) !important;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title .iconfont {
				margin: 0 3px;
				color: inherit;
				display: inline-block;
				vertical-align: middle;
				width: 34px;
				font-size: inherit;
				text-align: center;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title .el-submenu__icon-arrow {
				margin: -7px 0 0 0;
				top: 50%;
				color: inherit;
				vertical-align: middle;
				font-size: inherit;
				position: absolute;
				right: 20px;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 /deep/ .el-submenu.user .el-menu {
				border: none;
				background: rgba(255,255,255,.8);
				font-size: inherit;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user .el-menu .el-menu-item {
				padding: 0 40px !important;
				color: #666 !important;
				background: none !important;
				font-size: inherit !important;
				border-color: rgba(86,178,198,.1) !important;
				border-width: 0 0 1px !important;
				line-height: 50px !important;
				border-style: solid !important;
				height: 50px !important;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user .el-menu .el-menu-item:hover {
				padding: 0 40px !important;
				color: #333 !important;
				background: rgba(86,178,198,.3) !important;
				line-height: 50px !important;
				height: 50px !important;
			}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user .el-menu .el-menu-item.is-active {
				padding: 0 40px !important;
				color: #333 !important;
				background: rgba(86,178,198,.3) !important;
				line-height: 50px !important;
				height: 50px !important;
			}
	
	// 竖向 样式二-close-个人中心
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.user>.el-tooltip {
				cursor: pointer;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				background: #fff;
				font-size: inherit;
				position: relative;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.user>.el-tooltip:hover {
				color: #fff;
				background: rgba(86,178,198,.8);
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.user.is-active>.el-tooltip {
				color: #fff;
				background: rgba(86,178,198,.8);
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title {
				cursor: pointer !important;
				padding: 0 20px !important;
				color: #333 !important;
				white-space: nowrap !important;
				background: #fff !important;
				font-size: inherit !important;
				position: relative !important;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title:hover {
				color: #fff !important;
				background: rgba(86,178,198,.8) !important;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title .iconfont {
				margin: 0;
				color: inherit;
				display: inline-block;
				vertical-align: middle;
				width: 24px;
				font-size: 18px;
				text-align: center;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title .el-submenu__icon-arrow {
				margin: -7px 0 0 0;
				top: 50%;
				color: inherit;
				display: none;
				vertical-align: middle;
				font-size: 12px;
				position: absolute;
				right: 20px;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user .el-menu {
				border: none;
				padding: 0;
				font-size: inherit;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user .el-menu--vertical.user .el-menu-item {
				background-color: #fff;
				padding: 0 20px;
				color: #666;
				font-size: 14px;
				line-height: 44px;
				height: 44px;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user .el-menu--vertical.user .el-menu-item:hover {
				background-color: rgba(86,178,198,.8) !important;
				padding: 0 20px;
				color: #fff;
				line-height: 44px;
				height: 44px;
			}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user .el-menu--vertical.user .el-menu-item.is-active {
				background-color: rgba(86,178,198,.8) !important;
				padding: 0 20px;
				color: #fff;
				line-height: 44px;
				height: 44px;
			}
</style>
