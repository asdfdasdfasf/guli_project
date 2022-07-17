<template>
  <div class="app-container">
    讲师表单
    <el-form label-width="120px">
      <el-form-item label="讲师名称">
        <el-input v-model="teacher.name"/>
      </el-form-item>
      <el-form-item label="讲师排序">
        <el-input-number v-model="teacher.sort" controls-position="right" :min="0"/>
      </el-form-item>
      <el-form-item label="讲师头衔">
        <el-select v-model="teacher.level" clearable placeholder="请选择">
          <el-option :value="1" label="高级讲师"/>
          <el-option :value="2" label="首席讲师"/>
        </el-select>
      </el-form-item>
      <el-form-item label="讲师资历">
        <el-input v-model="teacher.career"/>
      </el-form-item>
      <el-form-item label="讲师简介">
        <el-input v-model="teacher.intro" :rows="10" type="textarea"/>
      </el-form-item>
      <!-- 讲师头像：TODO -->
      <!-- 讲师头像 -->
      <el-form-item label="讲师头像">

        <!-- 头衔缩略图 -->
        <pan-thumb :image="String(teacher.avatar)"/>
        <!-- 文件上传按钮 -->
        <el-button type="primary" icon="el-icon-upload" @click="imagecropperShow=true">更换头像
        </el-button>

        <image-cropper
          v-show="imagecropperShow"
          :width="300"
          :height="300"
          :key="imagecropperKey"
          :url="BASE_API+'/ossservice/update'"
          field="file"
          @close="close"
          @crop-upload-success="cropSuccess"/>
      </el-form-item>

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { saveTeacher } from '../../../api/edu/teacher'
import { queryTeacherById } from '../../../api/edu/teacher'
import { updateTeache } from '../../../api/edu/teacher'
import ImageCropper from '@/components/ImageCropper'
import PanThumb from '@/components/PanThumb'

export default {
  components:{ImageCropper,PanThumb},
  data() {
    return {
      teacher: {
        name: '',
        sort: 0,
        level: 1,
        career: '',
        intro: '',
        avatar: ''
      },
      imagecropperShow: false,
      imagecropperKey: 0,
      BASE_API:process.env.BASE_API,
      saveBtnDisabled: false  // 保存按钮是否禁用,
    }
  },
  created() {
    this.init()
  },
  watch: {  //监听
    $route(to, from) { //路由变化方式，路由发生变化，方法就会执行
      this.init()
    }
  },
  methods: {
    //取消上传图片
    close() {
      this.imagecropperShow=false
    },
    //图片上传
    cropSuccess(data){
        this.imagecropperShow=false;
        this.teacher.avatar=data.url
        this.imagecropperKey=this.imagecropperKey+1;
    },
    saveOrUpdate() {
      if (!this.teacher.id) {
        //添加
        this.saveTeacherInfo(this.teacher)
      } else {
        //修改
        this.updateTeacherInfo(this.teacher.id, this.teacher)
      }
    },

    //初始化方法
    init() {
      //判断路径有id值,做修改
      if (this.$route.params && this.$route.params.id) {
        //从路径获取id值
        const id = this.$route.params.id
        //调用根据id查询的方法
        this.queryTeacher(id)
      } else { //路径没有id值，做添加
        //清空表单
        this.teacher = {}
      }
    },
    //添加讲师信息
    saveTeacherInfo(teacher) {
      //调用api中定义的方法
      saveTeacher(teacher).then(response => {
        //提示添加信息成功
        this.$message({
          type: 'success',
          message: '添加讲师信息成功!'
        })
        //跳转到讲师展示页面
        this.$router.push({ path: '/teacher/table' })
      }).catch(error => {
        console.log(error)
      })
    },
    //根据id查询讲师信息
    queryTeacher(id) {
      queryTeacherById(id).then(response => {
        this.teacher = response.data.item
      })
    },
    //更新讲师信息
    updateTeacherInfo(id, teacher) {
      updateTeache(id, teacher).then(response => {
        //提示讲师信息更新完成
        this.$message({
          type: 'success',
          message: '更新讲师信息成功!'
        })
        //跳转到讲师展示页面
        this.$router.push({ path: '/teacher/table' })
      })
    }
  }
}
</script>
