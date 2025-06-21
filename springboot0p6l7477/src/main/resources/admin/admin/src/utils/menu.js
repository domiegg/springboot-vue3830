const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-discover",
                    "buttons": ["新增", "查看", "修改", "删除", "审核", "用户人数", "首页总数", "首页统计"],
                    "menu": "用户",
                    "menuJump": "列表",
                    "tableName": "yonghu"
                }],
                "menu": "用户管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-phone",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "宠物分类",
                    "menuJump": "列表",
                    "tableName": "meizhuangfenlei"
                }],
                "menu": "宠物分类管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-attentionfavor",
                    "buttons": ["查看", "删除", "查看评论", "首页总数", "首页统计", "宠物分类", "商品库存", "品牌比例"],
                    "menu": "宠物信息",
                    "menuJump": "列表",
                    "tableName": "mianshuishangpin"
                }],
                "menu": "宠物信息管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-explore",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "通知公告",
                    "menuJump": "列表",
                    "tableName": "tongzhigonggao"
                }],
                "menu": "通知公告管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-group",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "论坛交流",
                    "tableName": "forum"
                }],
                "menu": "论坛交流"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-brand",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "友情链接",
                    "tableName": "friendlink"
                }, {
                    "appFrontIcon": "cuIcon-album",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "轮播图管理",
                    "tableName": "config"
                }, {
                    "appFrontIcon": "cuIcon-form",
                    "buttons": ["查看", "删除"],
                    "menu": "在线留言",
                    "tableName": "onlinemessage"
                }, {
                    "appFrontIcon": "cuIcon-service",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "在线客服",
                    "tableName": "chat"
                }],
                "menu": "系统管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-goods",
                    "buttons": ["查看", "删除"],
                    "menu": "已取消订单",
                    "tableName": "orders/已取消"
                }, {
                    "appFrontIcon": "cuIcon-wenzi",
                    "buttons": ["查看", "删除"],
                    "menu": "已退款订单",
                    "tableName": "orders/已退款"
                }, {
                    "appFrontIcon": "cuIcon-album",
                    "buttons": ["查看", "删除"],
                    "menu": "未支付订单",
                    "tableName": "orders/未支付"
                }, {
                    "appFrontIcon": "cuIcon-goodsnew",
                    "buttons": ["查看", "删除", "物流"],
                    "menu": "已发货订单",
                    "tableName": "orders/已发货"
                }, {
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["查看", "删除", "发货"],
                    "menu": "已支付订单",
                    "tableName": "orders/已支付"
                }, {
                    "appFrontIcon": "cuIcon-pic",
                    "buttons": ["查看", "删除", "退货审核", "日销量", "月销量", "年销量", "品销量", "日销额", "月销额", "年销额", "品销额"],
                    "menu": "已完成订单",
                    "tableName": "orders/已完成"
                }],
                "menu": "订单管理"
            }],
            "frontMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-newshot",
                    "buttons": ["查看", "咨询商家"],
                    "menu": "宠物信息列表",
                    "menuJump": "列表",
                    "tableName": "mianshuishangpin"
                }],
                "menu": "宠物信息模块"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-discover",
                    "buttons": ["查看"],
                    "menu": "通知公告列表",
                    "menuJump": "列表",
                    "tableName": "tongzhigonggao"
                }],
                "menu": "通知公告模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "管理员",
            "tableName": "users"
        }]
    }
}
export default menu;
