<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>iS3</el-breadcrumb-item>
      <el-breadcrumb-item>报告</el-breadcrumb-item>
    </el-breadcrumb>

    <el-card>
      <!-- TSP地质预报S1S2 6个错误
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="code" label="程序输出"></el-table-column>
        <el-table-column prop="standard" label="标准输出"></el-table-column>
      </el-table>-->
      <img src="../../assets/is3_1.png" width="50%" />
      <img src="../../assets/is3_2.png" width="50%" />
      <img src="../../assets/is3_3.png" width="50%" />
      <img src="../../assets/is3_4.png" width="50%" />
    </el-card>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {};
  },
  methods: {
    search() {}
  },
  mounted() {}
};
</script>

<style lang="less" scoped>
.el-card {
  margin-bottom: 20px;
}
</style>
