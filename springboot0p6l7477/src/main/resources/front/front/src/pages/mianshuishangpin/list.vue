<template>
<div>
	<div :style='{"padding":"16px 12%","margin":"0px auto","borderColor":"#d8d8d8","borderRadius":"0px","background":"none","borderWidth":"0 0 3px","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'/'" :style='{"fontSize":"16px","lineHeight":"1","justifyContent":"flex-start","display":"flex"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index"><a>{{item.name}}</a></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div v-if="centerType" :style='{"padding":"16px 12%","margin":"0px auto","borderColor":"#d8d8d8","borderRadius":"0px","background":"none","borderWidth":"0 0 3px","width":"100%","borderStyle":"solid"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
	<div class="list-preview" :style='{"padding":"0 12%","margin":"0px auto","overflow":"hidden","alignItems":"flex-start","flexWrap":"wrap","background":"#fff","display":"block","width":"100%","position":"relative","justifyContent":"space-between"}'>
		

		<div class="category-3" :style='{"border":"0px solid #eee","padding":"0 40px","boxShadow":"0px 0px 0px #eee","margin":"0 aut","flexWrap":"wrap","background":"#f3f3f3","display":"flex","width":"100%","height":"auto","order":"3"}'>
			<div class="item" :class="swiperIndex == '-1' ? 'active' : ''" @click="getList(1, '全部')" :plain="isPlain">
				<div :style='{"color":"inherit","width":"100%","fontSize":"14px"}'>全部</div>
			</div>
			<div class="item" :class="swiperIndex == index ? 'active' : ''" v-for="(item, index) in fenlei" :key="index" @click="getList(1, item[feileiColumn], 'btn' + index)" :ref="'btn' + index" plain>
				<img v-if="item.image" :style='{"width":"100px","margin":"0 5px 0 0","objectFit":"cover","borderRadius":"4px","display":"block","height":"100px"}' :src="baseUrl + (item.image?item.image.split(',')[0]:'')">
				<div :style='{"color":"inherit","width":"100%","fontSize":"14px"}'>{{item[feileiColumn]}}</div>
			</div>
		</div>
	
    <el-form :inline="true" :model="formSearch" class="list-form-pv" :style='{"padding":"10px 0","margin":"20px 0 0","borderColor":"#ddd","alignItems":"center","display":"flex","clear":"both","float":"left","flexWrap":"wrap","background":"none","borderWidth":"0 0 0px","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
      <el-form-item :style='{"margin":"0 5px 0px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 0 0 0px","lineHeight":"42px","textAlign":"right","display":"inline-block"}'>商品名称：</div>
        <el-input v-model="formSearch.meizhuangmingcheng" placeholder="商品名称" @keydown.enter.native="getList(1, curFenlei)" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"margin":"0 5px 0px"}'>
		<div class="lable" v-if="true" :style='{"width":"auto","padding":"0 0 0 0px","lineHeight":"42px","textAlign":"right","display":"inline-block"}'>宠物分类：</div>
        <el-select v-model="formSearch.meizhuangfenlei" placeholder="请选择宠物分类" :clearable="true">
          <el-option v-for="(item, index) in meizhuangfenleiOptions" :key="index" :label="item" :value="item"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item :style='{"margin":"0 5px 0px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 0 0 0px","lineHeight":"42px","textAlign":"right","display":"inline-block"}'>品牌：</div>
        <el-input v-model="formSearch.pinpai" placeholder="品牌" @keydown.enter.native="getList(1, curFenlei)" clearable></el-input>
      </el-form-item>
      
      <el-form-item :style='{"margin":"0 5px 0px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 0 0 0px","lineHeight":"42px","textAlign":"right","display":"inline-block"}'>价格：</div>
        <el-input v-model="formSearch.pricestart" placeholder="最小价格" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"margin":"0 5px 0px"}'>
        <el-input v-model="formSearch.priceend" placeholder="最大价格" clearable></el-input>
      </el-form-item>
	  <el-button v-if=" true " :style='{"cursor":"pointer","border":"0","padding":"0px 15px","margin":"0px 10px 0 0px","color":"#fff","display":"inline-block","outline":"none","borderRadius":"30px","background":"#3795c4","width":"90px","fontSize":"14px","lineHeight":"40px","height":"40px"}' type="primary" @click="getList(1, curFenlei)"><i v-if="true" :style='{"color":"#fff","margin":"0 10px 0 0","fontSize":"16px"}' class="el-icon-search"></i>查询</el-button>
	  <el-button v-if="btnAuth('mianshuishangpin','新增')" :style='{"cursor":"pointer","border":"0px solid #ddd","padding":"0px 15px","margin":"0px 0px 0 0","color":"#fff","display":"inline-block","outline":"none","borderRadius":"30px","background":"#1c6a6d","width":"90px","fontSize":"14px","lineHeight":"40px","height":"40px"}' type="primary" @click="add('/index/mianshuishangpinAdd')"><i v-if="false" :style='{"color":"#fff","margin":"0 10px 0 0","fontSize":"14px"}' class="el-icon-circle-plus-outline"></i>添加</el-button>
    </el-form>
	<div class="sort_view" :style='{"padding":"10px 20px","margin":"26px 0 0","borderColor":"#3493c3","overflow":"hidden","borderRadius":"0px","textAlign":"right","background":"none","borderWidth":"0 0 3px","width":"calc(100% - 310px)","float":"left","borderStyle":"solid","order":"5"}'>
		<el-button :style='{"padding":"4px 15px","margin":"0 5px","borderColor":"#28890b","borderRadius":"0px","background":"none","borderWidth":"0 0px 0 0","borderStyle":"solid"}' @click="sortClick('price')">
			<span :style='{"margin":"0 2px 0 0","lineHeight":"20px","fontSize":"14px","color":"#929292","float":"right"}' class="icon iconfont icon-chujia13" v-if="sortType!='price'"></span>
			<span :style='{"margin":"0 2px 0 0","lineHeight":"20px","fontSize":"14px","color":"#929292","float":"right"}' class="icon iconfont icon-jiantou12" v-else-if="sortType=='price'&&sortOrder=='desc'"></span>
			<span :style='{"margin":"0 2px 0 0","lineHeight":"20px","fontSize":"14px","color":"#929292","float":"right"}' class="icon iconfont icon-jiantou38" v-else-if="sortType=='price'&&sortOrder=='asc'"></span>
			<span :style='{"margin":"0 4px 0 0","lineHeight":"20px","fontSize":"14px","color":"#929292"}'>价格</span>
		</el-button>
		<el-button :style='{"border":"0","padding":"4px 15px","margin":"0 5px","borderRadius":"0px","background":"none"}' @click="sortClick('clicknum')">
			<span :style='{"margin":"0 2px 0 0","lineHeight":"20px","fontSize":"14px","color":"#929292"}' class="icon iconfont icon-shousuo16" v-if="sortType!='clicknum'"></span>
			<span :style='{"margin":"0 2px 0 0","lineHeight":"20px","fontSize":"14px","color":"#929292"}' class="icon iconfont icon-jiantou12" v-else-if="sortType=='clicknum'&&sortOrder=='desc'"></span>
			<span :style='{"margin":"0 2px 0 0","lineHeight":"20px","fontSize":"14px","color":"#929292"}' class="icon iconfont icon-jiantou38" v-else-if="sortType=='clicknum'&&sortOrder=='asc'"></span>
			<span :style='{"color":"#929292","lineHeight":"20px","fontSize":"14px"}'>点击量</span>
		</el-button>
	</div>
	<div class="list" :style='{"minHeight":"699px","padding":"20px 0","margin":"20px 0 0","borderRadius":"0px","background":"none","width":"calc(100% - 310px)","float":"left","order":"6"}'>
		<!-- 样式一 -->
		<div class="list1 index-pv1" :style='{"padding":"0 0 0 2%","color":"#999","flexWrap":"wrap","background":"none","display":"flex","width":"100%","fontSize":"14px","height":"auto"}'>
			<div :style='{"border":"0px solid #ddd","cursor":"pointer","padding":"0 0 0px","boxShadow":"1px 2px 9px #ccc","margin":"0 2% 30px 0","display":"flex","justifyContent":"flex-end","overflow":"hidden","flexWrap":"wrap","background":"#fff","width":"23%","position":"relative","height":"auto"}' v-for="(item, index) in dataList" :key="index" @click.stop="toDetail(item)" class="list-item animation-box">
				<img @click.stop="imgPreView(item.fengmian)" :style='{"width":"100%","objectFit":"cover","display":"block","height":"240px"}' v-if="item.fengmian && item.fengmian.substr(0,4)=='http'" :src="item.fengmian" class="image" />
				<img @click.stop="imgPreView(baseUrl + (item.fengmian?item.fengmian.split(',')[0]:''))" :style='{"width":"100%","objectFit":"cover","display":"block","height":"240px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" class="image" />
				<div v-if="item.price" :style='{"padding":"0 10px","color":"#c00","textAlign":"right","width":"100%","lineHeight":"40px","fontSize":"inherit","order":"4"}' class="price"><span :style='{"fontSize":"12px"}'>￥</span>{{item.price}}</div>
				<div :style='{"padding":"0 10px","borderColor":"#ddd","margin":"0 0 6px","whiteSpace":"nowrap","color":"#333","textAlign":"left","overflow":"hidden","borderWidth":"0 0 0px","width":"100%","lineHeight":"32px","fontSize":"14px","textOverflow":"ellipsis","borderStyle":"dashed"}' class="name ">{{item.meizhuangmingcheng}}</div>
				<div :style='{"width":"auto","padding":"0px","textAlign":"left","display":"none","order":"5"}'>
				  <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"30px","fontSize":"inherit","color":"inherit","display":"none"}'></span>
				  <span class="text" :style='{"color":"#999","lineHeight":"30px","fontSize":"inherit"}'>{{item.addtime}}</span>
				</div>
				
				<div :style='{"padding":"0 0px","margin":"0 10px 0 0","display":"inline-block"}'>
				  <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
				  <span class="text" :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.thumbsupnum}}</span>
				</div>
				<div :style='{"padding":"0 0px","margin":"0 10px 0 0","display":"inline-block"}'>
				  <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
				  <span class="text" :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.storeupnum}}</span>
				</div>
				<div :style='{"padding":"0 0px","margin":"0 10px 0 0","display":"inline-block"}' v-if="item.clicknum">
				  <span class="icon iconfont icon-chakan2" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
				  <span class="text" :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.clicknum}}</span>
				</div>
			</div>
		</div>
		
	</div>

	<!-- 热门信息 -->
	<div class="hot" :style='{"padding":"0px","margin":"-40px 0 0","borderRadius":"0px","background":"#f1f1f1","width":"250px","float":"right","height":"auto","order":"5"}'>
	  <div :style='{"padding":"10px","color":"#fff","borderRadius":"0px","textAlign":"center","background":"#3795c4","width":"100%","fontSize":"22px","fontWeight":"500"}'>热门推荐</div>
	  <div :style='{"padding":"20px 10px 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
	    <div v-for="item in hotList" :key="item.id" :style='{"cursor":"pointer","width":"100%","margin":"0 0 20px","background":"#fff","height":"auto"}' @click="toDetail(item)">
	      <img :style='{"width":"100%","objectFit":"cover","float":"left","display":"block","height":"180px"}' v-if="item.fengmian && item.fengmian.substr(0,4)=='http'" :src="item.fengmian" alt="">
	      <img :style='{"width":"100%","objectFit":"cover","float":"left","display":"block","height":"180px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="">
	      <div :style='{"padding":"0 10px","borderColor":"#eee","whiteSpace":"nowrap","color":"#333","textAlign":"left","float":"right","overflow":"hidden","borderWidth":"0px","width":"100%","lineHeight":"30px","fontSize":"14px","textOverflow":"ellipsis","borderStyle":"solid"}'>{{item.meizhuangmingcheng}}</div>
	      <div :style='{"padding":"0 10px","borderColor":"#eee","whiteSpace":"nowrap","color":"#333","textAlign":"left","float":"right","overflow":"hidden","borderWidth":"0px","width":"100%","lineHeight":"30px","fontSize":"14px","textOverflow":"ellipsis","borderStyle":"solid"}'>{{item.dianpuming}}</div>
	      <!--<div :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"100%","lineHeight":"30px","fontSize":"14px","float":"right"}'>2022-02-02</div>-->
	    </div>
	  </div>
	</div>
	
	<el-pagination
	  background
	  id="pagination"
	  class="pagination"
	  :pager-count="7"
	  :page-size="pageSize"
	  :page-sizes="pageSizes"
	  prev-text="上一页"
	  next-text="下一页"
	  :hide-on-single-page="false"
	  :layout='["prev","pager","next"].join()'
	  :total="total"
	  :style='{"padding":"25px 0","margin":"0 auto","color":"#333","textAlign":"left","background":"none","width":"100%","clear":"both","lineHeight":"40px","fontWeight":"500","height":"auto","order":"50"}'
	  @current-change="curChange"
      @size-change="sizeChange"
	  @prev-click="prevClick"
	  @next-click="nextClick"
	></el-pagination>

  </div>
  <el-dialog title="预览图" :visible.sync="previewVisible" width="50%">
  	<img :src="previewImg" alt="" style="width: 100%;">
  </el-dialog>
</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
	    layouts: '',
		swiperIndex: -1,
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '宠物信息'
          }
        ],
        formSearch: {
          meizhuangmingcheng: '',
          meizhuangfenlei: '',
          pinpai: '',
          dianpuming: '',
          price: '',
        },
        fenlei: [],
		feileiColumn: '',
        hotList: [],
        dataList: [],
        total: 1,
        pageSize: 12,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        curFenlei: '全部',
        isPlain: false,
        indexQueryCondition: '',
	      meizhuangfenleiOptions: [],
        timeRange: [],
		centerType:false,
		previewImg: '',
		previewVisible: false,
		sortType: 'id',
		sortOrder: 'desc',
      }
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
		this.indexQueryCondition = this.$route.query.indexQueryCondition ? this.$route.query.indexQueryCondition : '';
		this.baseUrl = this.$config.baseUrl;
		this.$http.get('option/meizhuangfenlei/meizhuangfenlei').then(res => {
			if (res.data.code == 0) {
				this.meizhuangfenleiOptions = res.data.data;
			}
		});
      this.getFenlei();
      this.getList(1, '全部');
      this.getHotList();
    },
    //方法集合
    methods: {
		add(path) {
			let query = {}
			if(this.centerType){
				query.centerType = 1
			}
			this.$router.push({path: path,query:query});
		},
      getHotList() {
        let autoSortUrl = "";
        autoSortUrl = "mianshuishangpin/autoSort";
        if(localStorage.getItem('Token')) {
            autoSortUrl = "mianshuishangpin/autoSort2";
        }
          this.$http.get(autoSortUrl, {params: {
              page: 1,
              limit: 4,
          }}).then(res => {
              if (res.data.code == 0) {
                  this.hotList = res.data.data.list;
              }
          })
      },
      getFenlei() {
		this.$http.get('meizhuangfenlei/list',{}).then(res => {
		  if (res.data.code == 0) {
		    this.fenlei = res.data.data.list
		  }
		});
		this.feileiColumn = 'meizhuangfenlei'
      },
      getList(page, fenlei, ref = '') {
		if(fenlei == '全部') this.swiperIndex = -1;
		for(let i=0;i<this.fenlei.length;i++) {
			if(fenlei == this.fenlei[i][this.feileiColumn]) {
				this.swiperIndex = i;
				break;
			}
		}
		if(fenlei){
			this.curFenlei = fenlei;
		}
        // if (this.curFenlei == '全部') {
        //   this.isPlain = false;
        // } else {
        //   this.isPlain = true;
        // }
        let params = {page, limit: this.pageSize};
        let searchWhere = {};
        if (this.formSearch.meizhuangmingcheng != '') searchWhere.meizhuangmingcheng = '%' + this.formSearch.meizhuangmingcheng + '%';
        if (this.formSearch.meizhuangfenlei != '') searchWhere.meizhuangfenlei = this.formSearch.meizhuangfenlei;
        if (this.formSearch.pinpai != '') searchWhere.pinpai = '%' + this.formSearch.pinpai + '%';
        if (this.formSearch.dianpuming != '') searchWhere.dianpuming = '%' + this.formSearch.dianpuming + '%';
        if(this.formSearch.pricestart!='' && this.formSearch.pricestart!=undefined ){
          searchWhere.pricestart = this.formSearch.pricestart
        }
        if(this.formSearch.priceend!='' && this.formSearch.priceend!=undefined){
          searchWhere.priceend = this.formSearch.priceend
        }
        if (this.curFenlei != '全部') searchWhere.meizhuangfenlei = this.curFenlei;
		if (this.sortType) searchWhere.sort = this.sortType
		if (this.sortOrder) searchWhere.order = this.sortOrder
        this.$http.get(`mianshuishangpin/${this.centerType?'page':'list'}`, {params: Object.assign(params, searchWhere)}).then(res => {
          if (res.data.code == 0) {
            this.dataList = res.data.data.list;
            this.total = Number(res.data.data.total);
            this.pageSize = Number(res.data.data.pageSize);
            this.totalPage = res.data.data.totalPage;
			
			this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
          }
        });
      },
	  sortClick(type){
		  if(this.sortType==type){
			  if(this.sortOrder == 'desc'){
				  this.sortOrder = 'asc'
			  }else{
				  this.sortOrder = 'desc'
			  }
		  }else{
			  this.sortType = type
			  this.sortOrder = 'desc'
		  }
		  this.getList(1, '全部')
	  },
      curChange(page) {
        this.getList(page,this.curFenlei);
      },
      prevClick(page) {
        this.getList(page,this.curFenlei);
      },
      sizeChange(size){
        this.pageSize = size
        this.getList(1,this.curFenlei);
      },
      nextClick(page) {
        this.getList(page,this.curFenlei);
      },
	  imgPreView(url){
		  this.previewImg = url
		  this.previewVisible = true
	  },
      toDetail(item) {
		  let params = {
			  id: item.id
		  }
		  if(this.centerType){
			  params.centerType = 1
		  }
        this.$router.push({path: '/index/mianshuishangpinDetail', query: params});
      },
	btnAuth(tableName,key){
		if(this.centerType){
			return this.isBackAuth(tableName,key)
		}else{
			return this.isAuth(tableName,key)
		}
	},
	backClick() {
		this.$router.push({path: '/index/center'});
	},
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.list-preview .list-form-pv .el-input {
		width: auto;
	}

	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 9px;
		color: #ccc;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb .item1 /deep/ .el-breadcrumb__inner a {
		color: #999;
		display: inline-block;
	}
	
	.breadcrumb-preview .el-breadcrumb .item2 /deep/ .el-breadcrumb__inner a {
		color: #999;
		display: inline-block;
	}
	
	.category-1 .item {
		cursor: pointer;
		border: 0px solid #ddd;
		border-radius: 0px;
		padding: 16px 10px;
		margin: 0;
		color: #999;
		background: none;
		display: inline-block;
		width: auto;
		font-size: 16px;
		text-align: center;
		min-width: 120px;
	}
	
	.category-1 .item:hover {
		border: 0px solid #ddd;
		color: #fff;
		background: #3795c4;
		width: auto;
		font-size: 16px;
	}
	
	.category-1 .item.active {
		border: 0px solid #ddd;
		color: #fff;
		background: #3795c4;
		width: auto;
		font-size: 16px;
	}
	
	.category-2 .item {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item:hover {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item.active {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-3 .item {
		cursor: pointer;
		padding: 8px 10px;
		margin: 10px 4px;
		color: #333;
		display: flex;
		border-color: #ddd;
		line-height: 30px;
		flex-wrap: wrap;
		border-radius: 0px;
		background: none;
		width: auto;
		justify-content: center;
		border-width: 0 0px 0 0;
		align-items: center;
		border-style: solid;
		text-align: center;
		min-width: 120px;
	}
	
	.category-3 .item:hover {
		border-radius: 4px;
		padding: 8px 10px;
		color: #fff;
		background: #3795c4;
		width: auto;
		line-height: 30px;
	}
	
	.category-3 .item.active {
		border-radius: 4px;
		padding: 8px 10px;
		color: #fff;
		background: #3795c4;
		width: auto;
		line-height: 30px;
	}
	
	.list-form-pv .el-input /deep/ .el-input__inner {
		border: 0px solid #ddd;
		border-radius: 30px;
		padding: 0 10px;
		margin: 0;
		outline: none;
		color: #333;
		background: #f5f5f5;
		width: 140px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list-form-pv .el-select /deep/ .el-input__inner {
	}
	
	.list-form-pv .el-date-editor /deep/ .el-input__inner {
		border: 0px solid #ddd;
		border-radius: 30px;
		padding: 0 30px;
		margin: 0;
		outline: none;
		color: #333;
		background: #f5f5f5;
		display: inline-block;
		width: 140px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list .index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.list .index-pv1 .animation-box:hover {
		transform: rotate(0deg) scale(1.02) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		-webkit-perspective: 1000px;
		perspective: 1000px;
		transition: 0.3s;
		z-index: 1;
	}
	
	.list .index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.list .index-pv1 .animation-box img:hover {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		-webkit-perspective: 1000px;
		perspective: 1000px;
		transition: 0.3s;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 20px;
		padding: 0 16px;
		margin: 0 5px;
		color: #fff;
		background: #3795c4;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 20px;
		padding: 0 16px;
		margin: 0 5px;
		color: #fff;
		background: #3795c4;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 20px;
		padding: 0 16px;
		margin: 0 5px;
		color: #666;
		background: #dfdfdf;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 20px;
		padding: 0 16px;
		margin: 0 5px;
		color: #666;
		background: #dfdfdf;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 100%;
		background: #dfdfdf;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 100%;
		background: #3795c4;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 100%;
		background: #3795c4;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}

	
</style>
