<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>平时作业</el-breadcrumb-item>
      <el-breadcrumb-item>题目8--佣金问题</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 卡片视图区域 -->
    <el-card>
      <img src="../../assets/8.png" width="50%" />
      <img src="../../assets/81.png" width="50%" />
      <img src="../../assets/82.png" width="50%" />
      <img src="../../assets/83.png" width="50%" />
      <img src="../../assets/84.png" width="50%" />
      <img src="../../assets/85.png" width="50%" />
    </el-card>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {};
  },
  methods: {},
  mounted() {}
};
</script>

<style lang="less" scoped>
</style>
