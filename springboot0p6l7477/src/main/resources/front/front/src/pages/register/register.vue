<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231009/fb94a0e717b64fc3bcd4970c9397d98e.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"flex-end"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"minHeight":"800px","padding":"20px 5vw 0 5vw","margin":"40px 5% 40px 0","borderRadius":"0px","flexWrap":"wrap","background":"#fff","display":"flex","width":"40vw","position":"relative","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"width":"100%","margin":"0 0 10px 0","lineHeight":"44px","fontSize":"20px","color":"rgba(64, 158, 255, 1)","textAlign":"center"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"margin":"20px auto 20px","color":"#2a8ec0","textAlign":"center","width":"90%","letterSpacing":"2px","lineHeight":"44px","fontSize":"32px","fontWeight":"600"}'>基于JavaWeb的宠物商城平台 注册</p></div>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="zhanghao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('zhanghao')?'required':''">账号：</div>
				<el-input v-model="registerForm.zhanghao"  placeholder="请输入账号" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingming">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('xingming')?'required':''">姓名：</div>
				<el-input v-model="registerForm.xingming"  placeholder="请输入姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="nianling">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('nianling')?'required':''">年龄：</div>
				<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingbie">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in yonghuxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="shouji">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('shouji')?'required':''">商品：</div>
				<el-input v-model="registerForm.shouji"  placeholder="请输入商品" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="touxiang">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="yonghutouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='shangjia'" prop="shangjiazhanghao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('shangjiazhanghao')?'required':''">商家账号：</div>
				<el-input v-model="registerForm.shangjiazhanghao"  placeholder="请输入商家账号" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='shangjia'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='shangjia'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='shangjia'" prop="dianpuming">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('dianpuming')?'required':''">店铺名：</div>
				<el-input v-model="registerForm.dianpuming"  placeholder="请输入店铺名" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='shangjia'" prop="fuzeren">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('fuzeren')?'required':''">负责人：</div>
				<el-input v-model="registerForm.fuzeren"  placeholder="请输入负责人" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='shangjia'" prop="lianxidianhua">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
				<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='shangjia'" prop="touxiang">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="shangjiatouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 auto","color":"#fff","display":"block","outline":"none","borderRadius":"4px","background":"#3795c4","width":"400px","fontSize":"16px","height":"50px","order":"30"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 0px","margin":"0px auto","color":"#999","textAlign":"right","display":"none","outline":"none","borderRadius":"4px","background":"none","width":"400px","fontSize":"14px","height":"44px","order":"40"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0 0px","margin":"12px auto 20px","color":"#3795c4","textAlign":"center","display":"block","width":"400px","lineHeight":"1","fontSize":"14px","textDecoration":"none","order":"50"}' to="/login">已有账户登录</router-link>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
		}
    },
	mounted() {
		this.tableName = this.$route.query.role;
		if(this.tableName=='yonghu'){
			this.registerForm = {
                zhanghao: '',
                mima: '',
                xingming: '',
                nianling: '',
                xingbie: '',
                shouji: '',
                touxiang: '',
                sfsh: '',
                shhf: '',
                money: '',
			}
		}
		if(this.tableName=='shangjia'){
			this.registerForm = {
                shangjiazhanghao: '',
                mima: '',
                dianpuming: '',
                fuzeren: '',
                lianxidianhua: '',
                touxiang: '',
                ruzhushijian: '',
                sfsh: '',
                shhf: '',
                money: '',
			}
		}
		if ('yonghu' == this.tableName) {
			this.requiredRules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }]
		}
		if ('yonghu' == this.tableName) {
			this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
		}
		if ('yonghu' == this.tableName) {
			this.requiredRules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
		}
		if ('shangjia' == this.tableName) {
			this.requiredRules.shangjiazhanghao = [{ required: true, message: '请输入商家账号', trigger: 'blur' }]
		}
		if ('shangjia' == this.tableName) {
			this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
		}
		if ('shangjia' == this.tableName) {
			this.requiredRules.dianpuming = [{ required: true, message: '请输入店铺名', trigger: 'blur' }]
		}
	},
    created() {
      this.pageFlag = this.$route.query.pageFlag;
      if ('yonghu' == this.tableName) {
        this.rules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
        this.yonghuxingbieOptions = "男,女".split(',');
      if ('yonghu' == this.tableName) {
        this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.money = [{ required: true, validator: this.$validate.isNumber, trigger: 'blur' }];
      }
      if ('shangjia' == this.tableName) {
        this.rules.shangjiazhanghao = [{ required: true, message: '请输入商家账号', trigger: 'blur' }];
      }
      if ('shangjia' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
      if ('shangjia' == this.tableName) {
        this.rules.dianpuming = [{ required: true, message: '请输入店铺名', trigger: 'blur' }];
      }
      if ('shangjia' == this.tableName) {
        this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
        this.registerForm.ruzhushijian = this.getCurDate();
      if ('shangjia' == this.tableName) {
        this.rules.money = [{ required: true, validator: this.$validate.isNumber, trigger: 'blur' }];
      }
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      yonghutouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      shangjiatouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
			  if(this.tableName=='yonghu'){
				  this.registerForm.sfsh = '待审核'
			  }
				if((!this.registerForm.zhanghao) && `yonghu` == this.tableName){
					this.$message.error(`账号不能为空`);
					return
				}
               if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `yonghu` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.xingming) && `yonghu` == this.tableName){
					this.$message.error(`姓名不能为空`);
					return
				}
				if(`yonghu` == this.tableName && this.registerForm.nianling &&(!this.$validate.isIntNumer2(this.registerForm.nianling))){
					this.$message.error(`年龄应输入整数`);
					return
				}
					if(`yonghu` == this.tableName && this.registerForm.shouji &&(!this.$validate.isMobile2(this.registerForm.shouji))){
						this.$message.error(`商品应输入商品格式`);
						return
					}
			  if(this.tableName=='shangjia'){
				  this.registerForm.sfsh = '待审核'
			  }
				if((!this.registerForm.shangjiazhanghao) && `shangjia` == this.tableName){
					this.$message.error(`商家账号不能为空`);
					return
				}
               if(`shangjia` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `shangjia` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.dianpuming) && `shangjia` == this.tableName){
					this.$message.error(`店铺名不能为空`);
					return
				}
					if(`shangjia` == this.tableName && this.registerForm.lianxidianhua &&(!this.$validate.isMobile2(this.registerForm.lianxidianhua))){
						this.$message.error(`联系电话应输入商品格式`);
						return
					}
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20231009/fb94a0e717b64fc3bcd4970c9397d98e.jpg);
		
		.el-input {
		  width: auto;
		}
		
		.el-date-editor.el-input {
			width: auto;
		}
		
		.el-form-item /deep/ .el-form-item__content {
						display: flex;
						flex-wrap: wrap;
					}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 8px;
						padding: 0 10px;
						outline: none;
						color: #666;
						background: #fff;
						width: 400px;
						font-size: 14px;
						border-color: #c6c6c6;
						border-width: 2px;
						border-style: solid;
						height: 50px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border-radius: 8px;
						padding: 0 10px;
						outline: none;
						color: #666;
						background: #fff;
						width: 400px;
						font-size: 14px;
						border-color: #c6c6c6;
						border-width: 2px;
						border-style: solid;
						min-width: 300px;
						height: 50px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 8px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #666;
						background: #fff;
						width: 400px;
						font-size: 14px;
						border-color: #c6c6c6;
						border-width: 2px;
						border-style: solid;
						min-width: 300px;
						height: 50px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 8px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #666;
						background: #fff;
						width: 400px;
						font-size: 14px;
						border-color: #c6c6c6;
						border-width: 2px;
						border-style: solid;
						min-width: 300px;
						height: 50px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  cursor: pointer;
		  		  color: #c6c6c6;
		  		  font-weight: 600;
		  		  font-size: 32px;
		  		  border-color: #c6c6c6;
		  		  line-height: 60px;
		  		  border-radius: 30px;
		  		  background: #fff;
		  		  width: 120px;
		  		  border-width: 2px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  cursor: pointer;
		  		  color: #c6c6c6;
		  		  font-weight: 600;
		  		  font-size: 32px;
		  		  border-color: #c6c6c6;
		  		  line-height: 60px;
		  		  border-radius: 30px;
		  		  background: #fff;
		  		  width: 120px;
		  		  border-width: 2px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  cursor: pointer;
		  		  color: #c6c6c6;
		  		  font-weight: 600;
		  		  font-size: 32px;
		  		  border-color: #c6c6c6;
		  		  line-height: 60px;
		  		  border-radius: 30px;
		  		  background: #fff;
		  		  width: 120px;
		  		  border-width: 2px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: 90px;
				position: absolute;
				content: "*";
				order: 2;
			}
</style>
