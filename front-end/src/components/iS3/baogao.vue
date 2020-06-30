<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>iS3</el-breadcrumb-item>
      <el-breadcrumb-item>报告</el-breadcrumb-item>
    </el-breadcrumb>

    <el-card>
      TSP地质预报S1S2 6个错误
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="code" label="程序输出"></el-table-column>
        <el-table-column prop="standard" label="标准输出"></el-table-column>
      </el-table>
    </el-card>

    <el-card>
      TSP地质预报S3S4 16个错误
      <el-table :data="tableData2" border style="width: 100%">
        <el-table-column prop="code" label="程序输出"></el-table-column>
        <el-table-column prop="standard" label="标准输出"></el-table-column>
      </el-table>
    </el-card>

    <el-card>
      施工变更S3S4 0个错误
      <el-table :data="tableData3" border style="width: 100%">
        <el-table-column prop="code" label="程序输出"></el-table-column>
        <el-table-column prop="standard" label="标准输出"></el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      tableData: [
        {
          code: "灰岩",
          standard: "灰a岩"
        },
        {
          code: "灰岩",
          standard: "灰a岩"
        },
        {
          code: "灰岩",
          standard: "灰a岩"
        },
        {
          code: "灰岩夹泥岩",
          standard: "灰岩a夹泥岩"
        },
        {
          code: "灰岩夹泥岩",
          standard: "灰岩a夹泥岩"
        },
        {
          code: "灰岩夹泥岩",
          standard: "灰岩a夹泥岩"
        }
      ],
      tableData2: [
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        },
        {
          code: "石灰岩、粉砂岩",
          standard: "石灰岩、粉砂a岩"
        }
      ],
      tableData3: []
    };
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
