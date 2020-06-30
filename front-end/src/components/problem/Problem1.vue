<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>平时作业</el-breadcrumb-item>
      <el-breadcrumb-item>题目1--三角形、万年历</el-breadcrumb-item>
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
        <el-col :span="4">
          <el-select v-model="value2" placeholder="请选择">
            <el-option
              v-for="item in options2"
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
        <el-table-column prop="year" label="年"></el-table-column>
        <el-table-column prop="month" label="月"></el-table-column>
        <el-table-column prop="day" label="日"></el-table-column>
        <el-table-column prop="predict" label="预期输出"></el-table-column>
        <el-table-column prop="result" label="实际输出"></el-table-column>
        <el-table-column prop="pass" label="是否通过">
          <template slot-scope="scope">
            <el-tag :type="scope.row.pass? 'success' : 'danger'">{{scope.row.pass}}</el-tag>
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
        }
      ],
      value: "",
      options2: [
        {
          value: "选项1",
          label: "三角形"
        },
        {
          value: "选项2",
          label: "万年历"
        }
      ],
      value2: "",
      tableData: [
        {
          result: "输入不合法",
          month: 6,
          year: 2401,
          pass: true,
          predict: "输入不合法",
          "case-id": "60",
          day: 31
        },
        {
          result: "输入不合法",
          month: 6,
          year: 2401,
          pass: true,
          predict: "输入不合法",
          "case-id": "60",
          day: 31
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
