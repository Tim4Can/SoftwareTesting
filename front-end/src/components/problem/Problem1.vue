<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>平时作业</el-breadcrumb-item>
      <el-breadcrumb-item>题目1--三角形、万年历</el-breadcrumb-item>
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
      </el-tab-pane>
      <el-tab-pane label="边界类测试用例设计" name="second">
        <img src="../../assets/cal_bd1.png" width="50%" />
        <img src="../../assets/cal_bd2.png" width="50%" />
      </el-tab-pane>
      <el-tab-pane label="等价类测试用例设计" name="third">
        <img src="../../assets/cal_eq1.png" width="50%" />
        <img src="../../assets/cal_eq2.png" width="50%" />
      </el-tab-pane>
    </el-tabs>

    <el-tabs v-model="activeName2" @tab-click="handleClick">
      <el-tab-pane label="三角形" name="first">
        <!-- 卡片视图区域 -->
        <el-card>
          <!-- 搜索区域 -->
          <el-row :gutter="20">
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
              <el-button icon="el-icon-search" @click="search2()"></el-button>
            </el-col>
          </el-row>

          <el-table :data="tableData2" border style="width: 100%">
            <el-table-column prop="side1" label="边1"></el-table-column>
            <el-table-column prop="side2" label="边2"></el-table-column>
            <el-table-column prop="side3" label="边3"></el-table-column>
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
        <img src="../../assets/tri_bd.png" width="50%" />
      </el-tab-pane>
      <el-tab-pane label="等价类测试用例设计" name="third">
        <img src="../../assets/tri_eq1.png" width="50%" />
        <img src="../../assets/tri_eq2.png" width="50%" />
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
      activeName2: "first",
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
      tableData: [],
      options2: [
        {
          value: "选项1",
          label: "边界值"
        },
        {
          value: "选项2",
          label: "等价类"
        }
      ],
      value2: "",
      tableData2: [],
      CalenderBoundary: [
        {
          result: "年的值不在指定范围之内",
          month: 7,
          year: 1889,
          pass: true,
          predict: "年的值不在指定范围之内",
          "case-id": "1",
          day: 10
        },
        {
          result: "1900.7.11",
          month: 7,
          year: 1900,
          pass: true,
          predict: "1900.7.11",
          "case-id": "2",
          day: 10
        },
        {
          result: "1901.7.11",
          month: 7,
          year: 1901,
          pass: true,
          predict: "1901.7.11",
          "case-id": "3",
          day: 10
        },
        {
          result: "2049.7.11",
          month: 7,
          year: 2049,
          pass: true,
          predict: "2049.7.11",
          "case-id": "4",
          day: 10
        },
        {
          result: "2050.7.11",
          month: 7,
          year: 2050,
          pass: true,
          predict: "2050.7.11",
          "case-id": "5",
          day: 10
        },
        {
          result: "年的值不在指定范围之内",
          month: 7,
          year: 2051,
          pass: true,
          predict: "年的值不在指定范围之内",
          "case-id": "6",
          day: 10
        },
        {
          result: "月的值不在指定范围之内",
          month: 0,
          year: 2019,
          pass: true,
          predict: "月的值不在指定范围之内",
          "case-id": "7",
          day: 10
        },
        {
          result: "2019.1.11",
          month: 1,
          year: 2019,
          pass: true,
          predict: "2019.1.11",
          "case-id": "8",
          day: 10
        },
        {
          result: "2019.2.11",
          month: 2,
          year: 2019,
          pass: true,
          predict: "2019.2.11",
          "case-id": "9",
          day: 10
        },
        {
          result: "2019.11.11",
          month: 11,
          year: 2019,
          pass: true,
          predict: "2019.11.11",
          "case-id": "10",
          day: 10
        },
        {
          result: "2019.12.11",
          month: 12,
          year: 2019,
          pass: true,
          predict: "2019.12.11",
          "case-id": "11",
          day: 10
        },
        {
          result: "月的值不在指定范围之内",
          month: 13,
          year: 2019,
          pass: true,
          predict: "月的值不在指定范围之内",
          "case-id": "12",
          day: 10
        },
        {
          result: "2019.2.28",
          month: 2,
          year: 2019,
          pass: true,
          predict: "2019.2.28",
          "case-id": "13",
          day: 27
        },
        {
          result: "2019.3.1",
          month: 2,
          year: 2019,
          pass: true,
          predict: "2019.3.1",
          "case-id": "14",
          day: 28
        },
        {
          result: "日的值不在指定范围之内",
          month: 2,
          year: 2019,
          pass: true,
          predict: "日的值不在指定范围之内",
          "case-id": "15",
          day: 29
        },
        {
          result: "2020.2.29",
          month: 2,
          year: 2020,
          pass: true,
          predict: "2020.2.29",
          "case-id": "16",
          day: 28
        },
        {
          result: "2020.3.1",
          month: 2,
          year: 2020,
          pass: true,
          predict: "2020.3.1",
          "case-id": "17",
          day: 29
        },
        {
          result: "日的值不在指定范围之内",
          month: 2,
          year: 2020,
          pass: true,
          predict: "日的值不在指定范围之内",
          "case-id": "18",
          day: 30
        },
        {
          result: "2019.1.31",
          month: 1,
          year: 2019,
          pass: true,
          predict: "2019.1.31",
          "case-id": "19",
          day: 30
        },
        {
          result: "2019.2.1",
          month: 1,
          year: 2019,
          pass: true,
          predict: "2019.2.1",
          "case-id": "20",
          day: 31
        },
        {
          result: "日的值不在指定范围之内",
          month: 1,
          year: 2019,
          pass: true,
          predict: "日的值不在指定范围之内",
          "case-id": "21",
          day: 32
        },
        {
          result: "2019.5.1",
          month: 4,
          year: 2019,
          pass: true,
          predict: "2019.5.1",
          "case-id": "22",
          day: 30
        },
        {
          result: "日的值不在指定范围之内",
          month: 4,
          year: 2019,
          pass: true,
          predict: "日的值不在指定范围之内",
          "case-id": "23",
          day: 31
        },
        {
          result: "日的值不在指定范围之内",
          month: 4,
          year: 2019,
          pass: true,
          predict: "日的值不在指定范围之内",
          "case-id": "24",
          day: 32
        }
      ],
      CalenderEquivalence: [
        {
          result: "2016.3.1",
          month: 2,
          year: 2016,
          pass: true,
          predict: "2016.3.1",
          "case-id": "1",
          day: 29
        },
        {
          result: "2017.1.29",
          month: 1,
          year: 2017,
          pass: true,
          predict: "2017.1.29",
          "case-id": "2",
          day: 28
        },
        {
          result: "2017.2.1",
          month: 1,
          year: 2017,
          pass: true,
          predict: "2017.2.1",
          "case-id": "3",
          day: 31
        },
        {
          result: "2017.5.1",
          month: 4,
          year: 2017,
          pass: true,
          predict: "2017.5.1",
          "case-id": "4",
          day: 30
        },
        {
          result: "年的值不在指定范围之内",
          month: 3,
          year: 1899,
          pass: true,
          predict: "年的值不在指定范围之内",
          "case-id": "5",
          day: 1
        },
        {
          result: "年的值不在指定范围之内",
          month: 3,
          year: 2051,
          pass: true,
          predict: "年的值不在指定范围之内",
          "case-id": "6",
          day: 1
        },
        {
          result: "月的值不在指定范围之内",
          month: -1,
          year: 1901,
          pass: true,
          predict: "月的值不在指定范围之内",
          "case-id": "8",
          day: 1
        },
        {
          result: "月的值不在指定范围之内",
          month: 13,
          year: 1901,
          pass: true,
          predict: "月的值不在指定范围之内",
          "case-id": "9",
          day: 1
        },
        {
          result: "日的值不在指定范围之内",
          month: 1,
          year: 1901,
          pass: true,
          predict: "日的值不在指定范围之内",
          "case-id": "11",
          day: -1
        },
        {
          result: "日的值不在指定范围之内",
          month: 2,
          year: 2016,
          pass: true,
          predict: "日的值不在指定范围之内",
          "case-id": "12",
          day: 30
        },
        {
          result: "日的值不在指定范围之内",
          month: 2,
          year: 2017,
          pass: true,
          predict: "日的值不在指定范围之内",
          "case-id": "13",
          day: 29
        },
        {
          result: "日的值不在指定范围之内",
          month: 3,
          year: 2017,
          pass: true,
          predict: "日的值不在指定范围之内",
          "case-id": "14",
          day: 32
        },
        {
          result: "日的值不在指定范围之内",
          month: 4,
          year: 2017,
          pass: true,
          predict: "日的值不在指定范围之内",
          "case-id": "15",
          day: 31
        },
        {
          result: "日的值不在指定范围之内",
          month: 4,
          year: 2017,
          pass: true,
          predict: "日的值不在指定范围之内",
          "case-id": "16",
          day: 32
        }
      ],
      TriangleBoundary: [
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "0",
          predict: "您输入的边长信息有误！",
          "case-id": "1",
          side2: "50",
          side1: "50"
        },
        {
          result: "等腰三角形",
          pass: true,
          side3: "1.5",
          predict: "等腰三角形",
          "case-id": "2",
          side2: "50.5",
          side1: "50.5"
        },
        {
          result: "等腰三角形",
          pass: true,
          side3: "2",
          predict: "等腰三角形",
          "case-id": "3",
          side2: "50",
          side1: "50"
        },
        {
          result: "等边三角形",
          pass: true,
          side3: "50.5",
          predict: "等边三角形",
          "case-id": "4",
          side2: "50.5",
          side1: "50.5"
        },
        {
          result: "等腰三角形",
          pass: true,
          side3: "99",
          predict: "等腰三角形",
          "case-id": "5",
          side2: "50",
          side1: "50"
        },
        {
          result: "您输入的三边构不成三角形！",
          pass: true,
          side3: "100",
          predict: "您输入的三边构不成三角形！",
          "case-id": "6",
          side2: "50",
          side1: "50"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "101",
          predict: "您输入的边长信息有误！",
          "case-id": "7",
          side2: "50",
          side1: "50"
        },
        {
          result: "普通三角形",
          pass: true,
          side3: "54",
          predict: "普通三角形",
          "case-id": "8",
          side2: "43",
          side1: "33"
        },
        {
          result: "等腰三角形",
          pass: true,
          side3: "60.5",
          predict: "等腰三角形",
          "case-id": "9",
          side2: "50.0",
          side1: "50.0"
        },
        {
          result: "等边三角形",
          pass: true,
          side3: "55",
          predict: "等边三角形",
          "case-id": "10",
          side2: "55",
          side1: "55"
        },
        {
          result: "您输入的三边构不成三角形！",
          pass: true,
          side3: "50",
          predict: "您输入的三边构不成三角形！",
          "case-id": "11",
          side2: "5",
          side1: "5"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "35",
          predict: "您输入的边长信息有误！",
          "case-id": "12",
          side2: "17",
          side1: "-1"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "60.5",
          predict: "您输入的边长信息有误！",
          "case-id": "13",
          side2: "50.5",
          side1: "101.5"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "50",
          predict: "您输入的边长信息有误！",
          "case-id": "14",
          side2: "50",
          side1: "0"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "50",
          predict: "您输入的边长信息有误！",
          "case-id": "15",
          side2: "-2",
          side1: "5"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "7",
          predict: "您输入的边长信息有误！",
          "case-id": "16",
          side2: "102",
          side1: "50"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "60",
          predict: "您输入的边长信息有误！",
          "case-id": "17",
          side2: "0",
          side1: "50"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "-6",
          predict: "您输入的边长信息有误！",
          "case-id": "18",
          side2: "50",
          side1: "50"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "120",
          predict: "您输入的边长信息有误！",
          "case-id": "19",
          side2: "5",
          side1: "5"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "0",
          predict: "您输入的边长信息有误！",
          "case-id": "20",
          side2: "50",
          side1: "50"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "35",
          predict: "您输入的边长信息有误！",
          "case-id": "21",
          side2: "17",
          side1: "-1"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "60.5",
          predict: "您输入的边长信息有误！",
          "case-id": "22",
          side2: "101.5",
          side1: "46.5"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "-2",
          predict: "您输入的边长信息有误！",
          "case-id": "23",
          side2: "50",
          side1: "33"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "50",
          predict: "您输入的边长信息有误！",
          "case-id": "24",
          side2: "104",
          side1: "-6"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "-7",
          predict: "您输入的边长信息有误！",
          "case-id": "25",
          side2: "-32",
          side1: "20"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "100",
          predict: "您输入的边长信息有误！",
          "case-id": "26",
          side2: "99",
          side1: "-5"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "-6",
          predict: "您输入的边长信息有误！",
          "case-id": "27",
          side2: "-3",
          side1: "-6"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "-4",
          predict: "您输入的边长信息有误！",
          "case-id": "28",
          side2: "-5",
          side1: "103"
        }
      ],
      TriangleEquivalence: [
        {
          result: "普通三角形",
          pass: true,
          side3: "5",
          predict: "普通三角形",
          "case-id": "1",
          side2: "4",
          side1: "3"
        },
        {
          result: "等腰三角形",
          pass: true,
          side3: "5",
          predict: "等腰三角形",
          "case-id": "2",
          side2: "4",
          side1: "4"
        },
        {
          result: "等腰三角形",
          pass: true,
          side3: "4",
          predict: "等腰三角形",
          "case-id": "3",
          side2: "5",
          side1: "4"
        },
        {
          result: "等腰三角形",
          pass: true,
          side3: "4",
          predict: "等腰三角形",
          "case-id": "4",
          side2: "4",
          side1: "5"
        },
        {
          result: "等边三角形",
          pass: true,
          side3: "3",
          predict: "等边三角形",
          "case-id": "5",
          side2: "3",
          side1: "3"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "NULL",
          predict: "您输入的边长信息有误！",
          "case-id": "6",
          side2: "NULL",
          side1: "3"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "NULL",
          predict: "您输入的边长信息有误！",
          "case-id": "7",
          side2: "4",
          side1: "NULL"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "5",
          predict: "您输入的边长信息有误！",
          "case-id": "8",
          side2: "NULL",
          side1: "NULL"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "NULL",
          predict: "您输入的边长信息有误！",
          "case-id": "9",
          side2: "4",
          side1: "3"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "5",
          predict: "您输入的边长信息有误！",
          "case-id": "10",
          side2: "NULL",
          side1: "3"
        },
        {
          result: "您输入的边长信息有误！",
          pass: true,
          side3: "5",
          predict: "您输入的边长信息有误！",
          "case-id": "11",
          side2: "4",
          side1: "NULL"
        }
      ]
    };
  },
  methods: {
    search() {
      console.log(this.value);
      if (this.value == "选项1") {
        // this.tableData = this.CalenderBoundary;
        this.$axios
          .post("http://localhost:8021/test?service=2&type=bd")
          .then(response => {
            console.log(response.data);
            this.tableData = response.data;
          })
          .catch(() => {
            console.log("error");
          });
      }
      if (this.value == "选项2") {
        // this.tableData = this.CalenderEquivalence;
        this.$axios
          .post("http://localhost:8021/test?service=2&type=eq")
          .then(response => {
            console.log(response.data);
            this.tableData = response.data;
          })
          .catch(() => {
            console.log("error");
          });
      }
      // let param = {
      //   service: '3',
      //   type: 'bd'
      // };
      // this.$axios
      //   .post("http://localhost:8021/test?service=3&type=bd")
      //   .then(response => {
      //     console.log(response.data);
      //   })
      //   .catch(() => {
      //     console.log("error");
      //   });
    },
    search2() {
      console.log(this.value2);
      if (this.value2 == "选项1") {
        // this.tableData2 = this.TriangleBoundary;
        this.$axios
          .post("http://localhost:8021/test?service=1&type=bd")
          .then(response => {
            console.log(response.data);
            this.tableData2 = response.data;
          })
          .catch(() => {
            console.log("error");
          });
      }
      if (this.value2 == "选项2") {
        // this.tableData2 = this.TriangleEquivalence;
        this.$axios
          .post("http://localhost:8021/test?service=1&type=eq")
          .then(response => {
            console.log(response.data);
            this.tableData2 = response.data;
          })
          .catch(() => {
            console.log("error");
          });
      }
    },
    handleClick(tab, event) {
      console.log(tab, event);
    }
  },
  mounted() {}
};
</script>

<style lang="less" scoped>
</style>
