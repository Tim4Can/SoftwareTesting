<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>平时作业</el-breadcrumb-item>
      <el-breadcrumb-item>题目7--电信收费问题</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 卡片视图区域 -->
    <el-card>
      <!-- 搜索区域 -->
      <el-row :gutter="20">
        <el-col :span="4">
          <el-select v-model="value" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-col>
        <el-col :span="3">
          <el-button icon="el-icon-search" @click="search()"></el-button>
        </el-col>
      </el-row>

      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="time" label="通话时长(T)"></el-table-column>
        <el-table-column prop="number" label="未按时缴纳话费次数(N)"></el-table-column>
        <el-table-column prop="predict" label="预期输出"></el-table-column>
        <el-table-column prop="result" label="实际输出"></el-table-column>
        <el-table-column prop="pass" label="是否通过">
          <template slot-scope="scope">
            <el-tag :type="scope.row.pass == 'true' ? 'success' : 'danger'">{{scope.row.pass}}</el-tag>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      options: [
        {
          value: "选项1",
          label: "边界值"
        },
        {
          value: "选项2",
          label: "等价类"
        },
        {
          value: "选项3",
          label: "决策表"
        }
      ],
      value: "",
      tableData: [
        {
          "case-id": "B1",
          number: "0",
          time: "0",
          predict: "25.1225",
          result: "25.1225",
          pass: "true"
        },
        {
          "case-id": "B2",
          number: "1",
          time: "1",
          predict: "25.6585",
          result: "8587",
          pass: "false"
        }
      ]
    };
  },
  methods: {},
  mounted() {}
};
</script>

<style lang="less" scoped>
</style>
