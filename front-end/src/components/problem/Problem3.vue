<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>平时作业</el-breadcrumb-item>
      <el-breadcrumb-item>题目3--JUnit</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 卡片视图区域 -->
    <el-card>
      <el-row>
        <img src="../../assets/3.png" width="50%" />
        <img src="../../assets/30.png" width="50%" />
      </el-row>
      <el-row>
        <img src="../../assets/31.png" width="50%" />
        <img src="../../assets/32.png" width="50%" />
      </el-row>
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
