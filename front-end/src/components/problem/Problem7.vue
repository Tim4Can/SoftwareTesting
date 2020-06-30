<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>平时作业</el-breadcrumb-item>
      <el-breadcrumb-item>题目7--电信收费问题</el-breadcrumb-item>
    </el-breadcrumb>

    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="电信收费" name="first">
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
                <el-tag :type="scope.row.pass ? 'success' : 'danger'">{{scope.row.pass}}</el-tag>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-tab-pane>
      <el-tab-pane label="边界类说明" name="second">
        <img src="../../assets/dianfei_bd.png" width="50%" />
      </el-tab-pane>
      <el-tab-pane label="等价类说明" name="third">
        <img src="../../assets/dianfei_eq.png" width="50%" />
      </el-tab-pane>
      <el-tab-pane label="决策表说明" name="fourth">
        <img src="../../assets/dianfei_jc.png" width="50%" />
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
        },
        {
          value: "选项2",
          label: "弱一般等价类"
        },
        {
          value: "选项3",
          label: "强一般等价类"
        },
        {
          value: "选项4",
          label: "弱健壮等价类"
        },
        {
          value: "选项5",
          label: "强健壮等价类"
        },
        {
          value: "选项6",
          label: "决策表"
        }
      ],
      value: "",
      tableData: [],
      bdData: [
        {
          result: "话费为25.00",
          number: 0,
          pass: true,
          predict: "话费为25.00",
          "case-id": "B1",
          time: 0
        },
        {
          result: "话费为25.15",
          number: 1,
          pass: true,
          predict: "话费为25.15",
          "case-id": "B2",
          time: 1
        },
        {
          result: "话费为33.76",
          number: 1,
          pass: true,
          predict: "话费为33.76",
          "case-id": "B3",
          time: 59
        },
        {
          result: "话费为33.91",
          number: 1,
          pass: true,
          predict: "话费为33.91",
          "case-id": "B4",
          time: 60
        },
        {
          result: "话费为34.00",
          number: 2,
          pass: true,
          predict: "话费为34.00",
          "case-id": "B5",
          time: 60
        },
        {
          result: "话费为34.01",
          number: 2,
          pass: true,
          predict: "话费为34.01",
          "case-id": "B6",
          time: 61
        },
        {
          result: "话费为42.58",
          number: 2,
          pass: true,
          predict: "话费为42.58",
          "case-id": "B7",
          time: 119
        },
        {
          result: "话费为42.73",
          number: 2,
          pass: true,
          predict: "话费为42.73",
          "case-id": "B8",
          time: 120
        },
        {
          result: "话费为43.00",
          number: 3,
          pass: true,
          predict: "话费为43.00",
          "case-id": "B9",
          time: 120
        },
        {
          result: "话费为42.79",
          number: 3,
          pass: true,
          predict: "话费为42.79",
          "case-id": "B10",
          time: 121
        },
        {
          result: "话费为51.31",
          number: 3,
          pass: true,
          predict: "话费为51.31",
          "case-id": "B11",
          time: 179
        },
        {
          result: "话费为51.46",
          number: 3,
          pass: true,
          predict: "话费为51.46",
          "case-id": "B12",
          time: 180
        },
        {
          result: "话费为52.00",
          number: 4,
          pass: true,
          predict: "话费为52.00",
          "case-id": "B13",
          time: 180
        },
        {
          result: "话费为51.47",
          number: 3,
          pass: true,
          predict: "话费为51.47",
          "case-id": "B14",
          time: 181
        },
        {
          result: "话费为68.73",
          number: 3,
          pass: true,
          predict: "话费为68.73",
          "case-id": "B15",
          time: 299
        },
        {
          result: "话费为68.88",
          number: 3,
          pass: true,
          predict: "话费为68.88",
          "case-id": "B16",
          time: 300
        },
        {
          result: "话费为70.00",
          number: 4,
          pass: true,
          predict: "话费为70.00",
          "case-id": "B17",
          time: 300
        },
        {
          result: "话费为68.80",
          number: 6,
          pass: true,
          predict: "话费为68.80",
          "case-id": "B18",
          time: 301
        },
        {
          result: "话费为70.15",
          number: 7,
          pass: true,
          predict: "话费为70.15",
          "case-id": "B19",
          time: 301
        },
        {
          result: "话费为6720.85",
          number: 7,
          pass: true,
          predict: "话费为6720.85",
          "case-id": "B20",
          time: 44639
        },
        {
          result: "话费为6721.00",
          number: 11,
          pass: true,
          predict: "话费为6721.00",
          "case-id": "B21",
          time: 44640
        },
        {
          result: "话费为6721.00",
          number: 12,
          pass: true,
          predict: "话费为6721.00",
          "case-id": "B22",
          time: 44640
        },
        {
          result: "T值输入错误",
          number: 12,
          pass: true,
          predict: "T值输入错误",
          "case-id": "B23",
          time: 44641
        },
        {
          result: "T值输入错误",
          number: 12,
          pass: true,
          predict: "T值输入错误",
          "case-id": "B24",
          time: -1
        },
        {
          result: "N值输入错误",
          number: 13,
          pass: true,
          predict: "N值输入错误",
          "case-id": "B25",
          time: 400
        },
        {
          result: "N值输入错误",
          number: -1,
          pass: true,
          predict: "N值输入错误",
          "case-id": "B26",
          time: 400
        }
      ],
      eqData0: [
        {
          result: "话费为33.91",
          number: 1,
          pass: true,
          predict: "话费为33.91",
          "case-id": "R1",
          time: 60
        },
        {
          result: "话费为42.73",
          number: 2,
          pass: true,
          predict: "话费为42.73",
          "case-id": "R2",
          time: 120
        },
        {
          result: "话费为51.46",
          number: 3,
          pass: true,
          predict: "话费为51.46",
          "case-id": "R3",
          time: 180
        },
        {
          result: "话费为68.88",
          number: 3,
          pass: true,
          predict: "话费为68.88",
          "case-id": "R4",
          time: 300
        },
        {
          result: "话费为83.20",
          number: 6,
          pass: true,
          predict: "话费为83.20",
          "case-id": "R5",
          time: 400
        },
        {
          result: "话费为85.00",
          number: 7,
          pass: true,
          predict: "话费为85.00",
          "case-id": "R6",
          time: 400
        }
      ],
      eqData1: [
        {
          result: "T值输入错误",
          number: 1,
          pass: true,
          predict: "T值输入错误",
          "case-id": "R7",
          time: -10
        },
        {
          result: "T值输入错误",
          number: 1,
          pass: true,
          predict: "T值输入错误",
          "case-id": "R8",
          time: 44650
        },
        {
          result: "N值输入错误",
          number: -10,
          pass: true,
          predict: "N值输入错误",
          "case-id": "R9",
          time: 60
        },
        {
          result: "N值输入错误",
          number: 20,
          pass: true,
          predict: "N值输入错误",
          "case-id": "R10",
          time: 60
        }
      ],
      eqData2: [
        {
          result: "T值输入错误",
          number: 1,
          pass: true,
          predict: "T值输入错误",
          "case-id": "R7",
          time: -10
        },
        {
          result: "T值输入错误",
          number: 1,
          pass: true,
          predict: "T值输入错误",
          "case-id": "R8",
          time: 44650
        },
        {
          result: "N值输入错误",
          number: -10,
          pass: true,
          predict: "N值输入错误",
          "case-id": "R9",
          time: 60
        },
        {
          result: "N值输入错误",
          number: 20,
          pass: true,
          predict: "N值输入错误",
          "case-id": "R10",
          time: 60
        }
      ],
      eqData3: [
        {
          result: "N值输入错误",
          number: -10,
          pass: true,
          predict: "N值输入错误",
          "case-id": "R15",
          time: -10
        },
        {
          result: "N值输入错误",
          number: 20,
          pass: true,
          predict: "N值输入错误",
          "case-id": "R16",
          time: 44650
        },
        {
          result: "T值输入错误",
          number: 12,
          pass: true,
          predict: "T值输入错误",
          "case-id": "R17",
          time: -10
        },
        {
          result: "N值输入错误",
          number: -10,
          pass: true,
          predict: "N值输入错误",
          "case-id": "R18",
          time: 300
        }
      ],
      jcData: [
        {
          result: "话费为33.91",
          number: 1,
          pass: true,
          predict: "话费为33.91",
          "case-id": "S1",
          time: 60
        },
        {
          result: "话费为34.00",
          number: 5,
          pass: true,
          predict: "话费为34.00",
          "case-id": "S2",
          time: 60
        },
        {
          result: "话费为42.73",
          number: 2,
          pass: true,
          predict: "话费为42.73",
          "case-id": "S3",
          time: 120
        },
        {
          result: "话费为43.00",
          number: 5,
          pass: true,
          predict: "话费为43.00",
          "case-id": "S4",
          time: 120
        },
        {
          result: "话费为51.46",
          number: 3,
          pass: true,
          predict: "话费为51.46",
          "case-id": "S5",
          time: 180
        },
        {
          result: "话费为52.00",
          number: 6,
          pass: true,
          predict: "话费为52.00",
          "case-id": "S6",
          time: 180
        },
        {
          result: "话费为68.88",
          number: 3,
          pass: true,
          predict: "话费为68.88",
          "case-id": "S7",
          time: 300
        },
        {
          result: "话费为70.00",
          number: 8,
          pass: true,
          predict: "话费为70.00",
          "case-id": "S8",
          time: 300
        },
        {
          result: "话费为97.75",
          number: 6,
          pass: true,
          predict: "话费为97.75",
          "case-id": "S9",
          time: 500
        },
        {
          result: "话费为100.00",
          number: 8,
          pass: true,
          predict: "话费为100.00",
          "case-id": "S10",
          time: 500
        }
      ]
    };
  },
  methods: {
    search() {
      if (this.value == "选项1") {
        this.tableData = this.bdData;
      }
      if (this.value == "选项2") {
        this.tableData = this.eqData0;
      }
      if (this.value == "选项3") {
        this.tableData = this.eqData1;
      }
      if (this.value == "选项4") {
        this.tableData = this.eqData2;
      }
      if (this.value == "选项5") {
        this.tableData = this.eqData3;
      }
      if (this.value == "选项6") {
        this.tableData = this.jcData;
      }
    }
  },
  mounted() {}
};
</script>

<style lang="less" scoped>
</style>
