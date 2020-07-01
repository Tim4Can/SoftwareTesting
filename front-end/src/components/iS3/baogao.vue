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
      <!-- <img src="../../assets/is3_1.png" width="50%" />
      <img src="../../assets/is3_2.png" width="50%" />
      <img src="../../assets/is3_3.png" width="50%" />
      <img src="../../assets/is3_4.png" width="50%" /> -->

      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="id" label="用例编号" width="70px"></el-table-column>
        <el-table-column prop="filename" label="文件名"></el-table-column>
        <el-table-column prop="predict_result" label="预期结果"></el-table-column>
        <el-table-column prop="remark" label="备注"></el-table-column>
      </el-table>
    </el-card>

    <el-card>
      <el-table :data="tableData2" border style="width: 100%">
        <el-table-column prop="id" label="用例编号" width="70px"></el-table-column>
        <el-table-column prop="para" label="提取段落"></el-table-column>
        <el-table-column prop="predict_result" label="预期结果"></el-table-column>
        <el-table-column prop="remark" label="备注"></el-table-column>
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
          id: "1",
          filename: "002期-老营特长隧道 右幅进口K1+505-530.doc",
          predict_result: "程序将doc文件转成docx文件并进行提取，提取后输出结果",
          remark: "文件类型兼容"
        },
        {
          id: "2",
          filename: "002期-老营特长隧道 右幅进口K1+505-530.docx",
          predict_result: "程序正常对文件进行提取，提取后输出结果",
          remark: "文件类型兼容"
        },
        {
          id: "3",
          filename: "隧道明细.xls",
          predict_result: "程序正常对文件进行提取，提取后输出结果",
          remark: "文件类型兼容"
        },
        {
          id: "4",
          filename: "土建S4合同.xlsx",
          predict_result: "程序正常对文件进行提取，提取后输出结果",
          remark: "文件类型兼容"
        },
        {
          id: "5",
          filename: '“c:/users/dell/desktop/is3/resources"',
          predict_result: "程序根据绝对路径找到指定文件，正常运行",
          remark: "文件路径问题"
        },
        {
          id: "6",
          filename: "“./resources”",
          predict_result: "程序根据相对路径拼接文件夹路径，正常运行",
          remark: "文件路径问题"
        }
      ],
      tableData2: [
        {
          id: '7',
          para: 'K1+440～K1+355',
          predict_result: 'K1+440～K1+355',
          remark: '桩号区间空格问题'
        },
        {
          id: '8',
          para: 'K 1+440～K 1+355',
          predict_result: 'K1+440～K1+355',
          remark: '桩号区间空格问题'
        },
        {
          id: '9',
          para: '设计与预报围岩分级对照表结构特征和完整状态一栏：岩体呈厚层状构造，岩体较破碎。',
          predict_result: '岩体呈厚层状构造，岩体较破碎。',
          remark: '半角、全角问题'
        },
        {
          id: '10',
          para: '设计与预报围岩分级对照表结构特征和完整状态一栏：岩体呈厚层状构造,岩体较破碎。',
          predict_result: '岩体呈厚层状构造，岩体较破碎。',
          remark: '半角、全角问题'
        },
        {
          id: '11',
          para: '岩体：灰岩',
          predict_result: '灰岩',
          remark: '半角、全角问题'
        },
        {
          id: '12',
          para: '岩体:灰岩',
          predict_result: '灰岩',
          remark: '半角、全角问题'
        },
        {
          id: '13',
          para: '风化：强~中等风化',
          predict_result: '强~中等风化',
          remark: '半角、全角问题'
        },
        {
          id: '14',
          para: '风化：强～中等风化',
          predict_result: '强~中等风化',
          remark: '半角、全角问题'
        },
        {
          id: '15',
          para: '风化：强-中等风化',
          predict_result: '强~中等风化',
          remark: '符号替换问题'
        },
        {
          id: '16',
          para: 'pdf表格：YK12+425～YK12+372',
          predict_result: 'YK12+425～YK12+372',
          remark: 'pdf表格横纵向提取问题'
        },
        {
          id: '17',
          para: 'pdf表格：K1+425～K1+372',
          predict_result: 'K1+425～K1+372',
          remark: 'pdf表格横纵向提取问题'
        },
        {
          id: '18',
          para: '第三个表格，全文共三个表格',
          predict_result: '正确定位到提取逻辑的表格进行提取',
          remark: '表格数组越界问题'
        },
        {
          id: '19',
          para: '第二个表格，全文共两个表格',
          predict_result: '正确定位到提取逻辑的表格进行提取，不发生表格的数组越界',
          remark: '表格数组越界问题'
        },
        {
          id: '20',
          para: 'word文档，单元格合并',
          predict_result: '跳过与上一格和左一格相等的单元格',
          remark: '单元格合并问题'
        },
        {
          id: '21',
          para: 'pdf文件，单元格合并',
          predict_result: '跳过值为null的单元格',
          remark: '单元格合并问题'
        },
        {
          id: '22',
          para: '围岩灰色中厚层砂质灰岩，中等风化，局部夹黄褐色强风化砂岩，砂质灰岩岩质较坚硬',
          predict_result: '中等风化',
          remark: '是否提取到字段'
        },
        {
          id: '23',
          para: '未找到匹配的段落',
          predict_result: '无',
          remark: '是否提取到字段'
        },
        {
          id: '24',
          para: '地下水，“潮湿”性状后勾选',
          predict_result: '潮湿',
          remark: '多选框问题'
        },
        {
          id: '25',
          para: '地下水，多个性状后勾选',
          predict_result: '湿润~潮湿',
          remark: '多选框问题'
        },
        {
          id: '26',
          para: '岩性：砂岩',
          predict_result: '砂岩',
          remark: '多字段提取问题'
        },
        {
          id: '27',
          para: '岩性：强风化砂岩',
          predict_result: '砂岩',
          remark: '多字段提取问题'
        },
        {
          id: '28',
          para: '进口右幅掌子面前方0～25m（K1+575～K1+600）段，整体电磁波振幅变化较大，同相轴连续性较差，反射频率变化较大',
          predict_result: '25',
          remark: '中英文提取问题'
        },
        {
          id: '29',
          para: '进口右幅掌子面前方0～25米（K1+575～K1+600）段，整体电磁波振幅变化较大，同相轴连续性较差，反射频率变化较大',
          predict_result: '25',
          remark: '中英文提取问题'
        },
        {
          id: '30',
          para: '时间：2018年7月',
          predict_result: '2018-7',
          remark: '时间格式统一问题'
        },
        {
          id: '31',
          para: '时间：2018.7',
          predict_result: '2018-7',
          remark: '时间格式统一问题'
        },
        {
          id: '32',
          para: '时间：2018-7',
          predict_result: '2018-7',
          remark: '时间格式统一问题'
        },
        {
          id: '33',
          para: 'K1+100',
          predict_result: 'K1+100',
          remark: '左右幅问题'
        },
        {
          id: '34',
          para: 'ZK1+100',
          predict_result: 'ZK1+100',
          remark: '左右幅问题'
        },
        {
          id: '35',
          para: 'word:岩体呈碎裂状结构，岩体破碎',
          predict_result: '岩体呈碎裂状结构，岩体破碎',
          remark: 'pdf换行问题'
        }
      ]
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
