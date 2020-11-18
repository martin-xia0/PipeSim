## 11.12
### JSON: fastjson
	配pom
### SpringBoot: maven
	mvn spring-boot:run
	mvn clean package
	java -jar xxx.jar
### git
	配合vscode
### postman 
### 完善 
	pipseg
	组件表，管网上的组件，参数列表，属性
### 接口传参
    restful 规范


## 11.15
### 模型思维导图 xmind -> 解决方案
    目前选择的技术路线
    科技树
    可选技术路线（其他方案)

### 代码工具再熟悉 
#### git
#### postman 

### 前端晋级小灶
    vue 一周1h 5次 问答+讨论+源码分析
	w3school: html+css+javascript
	vue -> javascript

### 近期
#### 讨论参数类，network -> 接口（json带什么参数）
#### 催数据采集，硬件（调通没有）+软件（接口）

## 11.17
### 一些调整
- 继承类 Node -> 管件附着物
- component 里面都是物理对象
- calculator -> getxxx
- node 初始化map查询

### Network 数据结构
  - 排列顺序，假设管网就是Node和Pipe的组合，但如何描述这个组合，用哪种数据结构？
  - ArrayList Set
  - 管网的build，传入数据应该长啥样，如何解析json->network 



### IDEA
- 先以无序集合输入
  再选择子集，生成顺序

## 11.18
### network
- network 是 component 的集合 ArrayList
- UserArea 是 component 的子类，纯粹吃流量不干扰压力

### 如何定义分叉点
- ArrayList network， 分叉就是branch
- branch（纯粹吃流量不干扰压力）-> 关联到一个network_id，计算总共分出去多少水
- Map branch_id -> network
- Queue branch queue 存放未计算的network
- 最终搜索完所有支路，把所有network算一遍
  

### 传入数据
#### 管网拓扑结构
构造整个数据结构
环境数据
#### 模拟状态数据
- 用户用水量
- 出厂水压


### 目前问题
- 传入数据（Json）的组织方式