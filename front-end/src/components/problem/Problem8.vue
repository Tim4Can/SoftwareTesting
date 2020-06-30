<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>平时作业</el-breadcrumb-item>
      <el-breadcrumb-item>题目8--佣金问题</el-breadcrumb-item>
    </el-breadcrumb>

    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="佣金问题" name="first">
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
            <el-table-column prop="volume" label="volume"></el-table-column>
            <el-table-column prop="day" label="day"></el-table-column>
            <el-table-column prop="rate" label="rate"></el-table-column>
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
      <el-tab-pane label="题目说明" name="second">
        <!-- 卡片视图区域 -->
        <el-card>
          <img src="../../assets/8.png" width="50%" />
          <img src="../../assets/81.png" width="50%" />
          <img src="../../assets/82.png" width="50%" />
          <img src="../../assets/83.png" width="50%" />
          <img src="../../assets/84.png" width="50%" />
          <img src="../../assets/85.png" width="50%" />
        </el-card>
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
          label: "条件覆盖"
        },
        {
          value: "选项2",
          label: "语句覆盖"
        },
        {
          value: "选项3",
          label: "判定覆盖"
        },
        {
          value: "选项4",
          label: "条件组合覆盖"
        },
        {
          value: "选项5",
          label: "判定条件覆盖"
        }
      ],
      value: "",
      tableData: []
    };
  },
  methods: {
    search() {
      if (this.value == "选项1") {
        // this.tableData = this.bdData;
        this.$axios
          .post("http://localhost:8021/test?service=8&type=cond")
          .then(response => {
            console.log(response.data);
            this.tableData = response.data;
          })
          .catch(() => {
            console.log("error");
          });
      }
      if (this.value == "选项2") {
        // this.tableData = this.eqData0;
        this.$axios
          .post("http://localhost:8021/test?service=8&type=sts")
          .then(response => {
            console.log(response.data);
            this.tableData = response.data;
          })
          .catch(() => {
            console.log("error");
          });
      }
      if (this.value == "选项3") {
        // this.tableData = this.eqData1;
        this.$axios
          .post("http://localhost:8021/test?service=8&type=decis")
          .then(response => {
            console.log(response.data);
            this.tableData = response.data;
          })
          .catch(() => {
            console.log("error");
          });
      }
      if (this.value == "选项4") {
        // this.tableData = this.eqData2;
        this.$axios
          .post("http://localhost:8021/test?service=8&type=cc")
          .then(response => {
            console.log(response.data);
            this.tableData = response.data;
          })
          .catch(() => {
            console.log("error");
          });
      }
      if (this.value == "选项5") {
        // this.tableData = this.eqData3;
        this.$axios
          .post("http://localhost:8021/test?service=8&type=dc")
          .then(response => {
            console.log(response.data);
            this.tableData = response.data;
          })
          .catch(() => {
            console.log("error");
          });
      }
    }
  },
  mounted() {}
};
</script>

<style lang="less" scoped>
</style>
