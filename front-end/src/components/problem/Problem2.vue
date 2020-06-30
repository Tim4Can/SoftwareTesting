<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>平时作业</el-breadcrumb-item>
      <el-breadcrumb-item>题目2--佣金问题</el-breadcrumb-item>
    </el-breadcrumb>

    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="万年历" name="first">
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
            <el-table-column prop="host" label="主机"></el-table-column>
            <el-table-column prop="monitor" label="显示器"></el-table-column>
            <el-table-column prop="peripheral" label="外设"></el-table-column>
            <el-table-column prop="predict" label="预期输出"></el-table-column>
            <el-table-column prop="result" label="实际输出"></el-table-column>
            <el-table-column prop="pass" label="是否通过">
              <template slot-scope="scope">
                <el-tag :type="scope.row.pass? 'success' : 'danger'">{{scope.row.pass}}</el-tag>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-tab-pane>
      <el-tab-pane label="边界类测试用例设计" name="second">
        <img src="../../assets/comission.png" width="50%" />
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      activeName: "first",
      options: [
        {
          value: "选项1",
          label: "边界值"
        }
      ],
      value: "",
      tableData: [],
      Comission: [
        {
          result: 0.0,
          peripheral: "46",
          pass: true,
          host: "-1",
          predict: 0.0,
          "case-id": "1",
          monitor: "40"
        },
        {
          result: 0.0,
          peripheral: "46",
          pass: true,
          host: "0",
          predict: 0.0,
          "case-id": "2",
          monitor: "40"
        },
        {
          result: 659.0,
          peripheral: "46",
          pass: true,
          host: "1",
          predict: 659.0,
          "case-id": "3",
          monitor: "40"
        },
        {
          result: 669.0,
          peripheral: "46",
          pass: true,
          host: "3",
          predict: 669.0,
          "case-id": "4",
          monitor: "40"
        },
        {
          result: 854.0,
          peripheral: "46",
          pass: true,
          host: "40",
          predict: 854.0,
          "case-id": "5",
          monitor: "40"
        },
        {
          result: 994.0,
          peripheral: "46",
          pass: true,
          host: "68",
          predict: 994.0,
          "case-id": "6",
          monitor: "40"
        },
        {
          result: 1004.0,
          peripheral: "46",
          pass: true,
          host: "70",
          predict: 1004.0,
          "case-id": "7",
          monitor: "40"
        },
        {
          result: -1.0,
          peripheral: "46",
          pass: true,
          host: "72",
          predict: -1.0,
          "case-id": "8",
          monitor: "40"
        },
        {
          result: 0.0,
          peripheral: "46",
          pass: true,
          host: "40",
          predict: 0.0,
          "case-id": "9",
          monitor: "0"
        },
        {
          result: 620.0,
          peripheral: "46",
          pass: true,
          host: "40",
          predict: 620.0,
          "case-id": "10",
          monitor: "1"
        },
        {
          result: 626.0,
          peripheral: "46",
          pass: true,
          host: "40",
          predict: 626.0,
          "case-id": "11",
          monitor: "2"
        },
        {
          result: 1088.0,
          peripheral: "46",
          pass: true,
          host: "40",
          predict: 1088.0,
          "case-id": "13",
          monitor: "79"
        },
        {
          result: 1094.0,
          peripheral: "46",
          pass: true,
          host: "40",
          predict: 1094.0,
          "case-id": "14",
          monitor: "80"
        },
        {
          result: -1.0,
          peripheral: "46",
          pass: true,
          host: "40",
          predict: -1.0,
          "case-id": "15",
          monitor: "81"
        },
        {
          result: 0.0,
          peripheral: "0",
          pass: true,
          host: "40",
          predict: 0.0,
          "case-id": "16",
          monitor: "40"
        },
        {
          result: 449.0,
          peripheral: "1",
          pass: true,
          host: "40",
          predict: 449.0,
          "case-id": "17",
          monitor: "40"
        },
        {
          result: 458.0,
          peripheral: "2",
          pass: true,
          host: "40",
          predict: 458.0,
          "case-id": "18",
          monitor: "40"
        },
        {
          result: 1223.0,
          peripheral: "87",
          pass: true,
          host: "40",
          predict: 1223.0,
          "case-id": "20",
          monitor: "40"
        },
        {
          result: 1250.0,
          peripheral: "90",
          pass: true,
          host: "40",
          predict: 1250.0,
          "case-id": "21",
          monitor: "40"
        },
        {
          result: -1.0,
          peripheral: "91",
          pass: true,
          host: "40",
          predict: -1.0,
          "case-id": "22",
          monitor: "40"
        },
        {
          result: 97.0,
          peripheral: "10",
          pass: true,
          host: "10",
          predict: 97.0,
          "case-id": "23",
          monitor: "9"
        },
        {
          result: 97.0,
          peripheral: "6",
          pass: true,
          host: "10",
          predict: 97.0,
          "case-id": "24",
          monitor: "15"
        },
        {
          result: 100.0,
          peripheral: "10",
          pass: true,
          host: "10",
          predict: 100.0,
          "case-id": "25",
          monitor: "10"
        },
        {
          result: 100.0,
          peripheral: "2",
          pass: true,
          host: "34",
          predict: 100.0,
          "case-id": "26",
          monitor: "2"
        },
        {
          result: 153.75,
          peripheral: "4",
          pass: true,
          host: "23",
          predict: 153.75,
          "case-id": "27",
          monitor: "9"
        },
        {
          result: 153.75,
          peripheral: "10",
          pass: true,
          host: "11",
          predict: 153.75,
          "case-id": "28",
          monitor: "10"
        },
        {
          result: 263.25,
          peripheral: "12",
          pass: true,
          host: "9",
          predict: 263.25,
          "case-id": "29",
          monitor: "33"
        },
        {
          result: 263.25,
          peripheral: "17",
          pass: true,
          host: "18",
          predict: 263.25,
          "case-id": "30",
          monitor: "18"
        },
        {
          result: 270.0,
          peripheral: "18",
          pass: true,
          host: "18",
          predict: 270.0,
          "case-id": "31",
          monitor: "18"
        },
        {
          result: 270.0,
          peripheral: "29",
          pass: true,
          host: "3",
          predict: 270.0,
          "case-id": "32",
          monitor: "14"
        },
        {
          result: 366.0,
          peripheral: "18",
          pass: true,
          host: "18",
          predict: 366.0,
          "case-id": "33",
          monitor: "19"
        },
        {
          result: 366.0,
          peripheral: "31",
          pass: true,
          host: "9",
          predict: 366.0,
          "case-id": "34",
          monitor: "7"
        }
      ]
    };
  },
  methods: {
    search() {
      this.tableData = this.Comission;
    }
  },
  mounted() {}
};
</script>

<style lang="less" scoped>
</style>
