<template>

    <div class="app-container">

        <h2 style="text-align: center;">发布新课程</h2>

        <el-steps :active="1" process-status="wait" align-center style="margin-bottom: 40px;">
            <el-step title="填写课程基本信息" />
            <el-step title="创建课程大纲" />
            <el-step title="提交审核" />
        </el-steps>

        <el-form label-width="120px">

            <el-form-item label="课程标题">
                <el-input v-model="courseInfoVo.title" placeholder=" 示例：机器学习项目课：从基础到搭建项目视频课程。专业名称注意大小写" />
            </el-form-item>

            <!-- 所属分类 TODO -->
            <el-form-item label="课程分类">
                <el-select v-model="courseInfoVo.subjectParentId" placeholder="一级分类" @change="subjectLevelOneChanged">

                    <el-option v-for="subject in subjectOneList" :key="subject.id" :label="subject.title"
                        :value="subject.id" />

                </el-select>

                <!-- 二级分类 -->
                <el-select v-model="courseInfoVo.subjectId" placeholder="二级分类">
                    <el-option v-for="subject in subjectTwoList" :key="subject.id" :label="subject.title"
                        :value="subject.id" />
                </el-select>
            </el-form-item>


            <!-- 课程讲师 TODO -->
            <!-- 课程讲师 -->
            <el-form-item label="课程讲师">
                <el-select v-model="courseInfoVo.teacherId" placeholder="请选择">

                    <el-option v-for="teacher in teacherList" :key="teacher.id" :label="teacher.name"
                        :value="teacher.id" />

                </el-select>
            </el-form-item>

            <el-form-item label="总课时">
                <el-input-number :min="0" v-model="courseInfoVo.lessonNum" controls-position="right"
                    placeholder="请填写课程的总课时数" />
            </el-form-item>

            <!-- 课程简介 TODO -->
            <el-form-item label="课程简介">
                <el-input v-model="courseInfoVo.description" placeholder=" " />
            </el-form-item>


            <!-- 课程封面 TODO -->
            <!-- 课程封面-->
            <el-form-item label="课程封面">

                <el-upload :show-file-list="false" :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload"
                    :action="BASE_API + '/ossservice/update'" class="avatar-uploader">
                    <img :src="courseInfoVo.cover" width="400" height="200">
                </el-upload>

            </el-form-item>

            <el-form-item label="课程价格">
                <el-input-number :min="0" v-model="courseInfoVo.price" controls-position="right"
                    placeholder="免费课程请设置为0元" /> 元
            </el-form-item>

            <el-form-item>
                <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">保存并下一步</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
import { addCourse } from '../../../api/edu/course'
import { getAllTeacher } from '../../../api/edu/course'
import { getAllSubject } from '../../../api/edu/subject'
import Tinymce from '@/components/Tinymce'
import { getCourseInfoId } from '../../../api/edu/course'
import {updateCourseInfo} from '../../../api/edu/course'
export default {
    components: { Tinymce },
    data() {
        return {
            saveBtnDisabled: false, // 保存按钮是否禁用
            courseInfoVo: {
                title: '',
                subjectId: '',//二级分类id
                subjectParentId: '',//一级分类id
                teacherId: '',
                lessonNum: 0,
                description: '',
                cover: '/static/01.jpg',
                price: 0
            },
            courseId: '',
            BASE_API: process.env.BASE_API,
            teacherList: [],
            subjectOneList: [],
            subjectTwoList: [],
            chapterVideoList: []
        }
    },

    created() {
        //获取路由中的id值
        if (this.$route.params && this.$route.params.id) {
            this.courseId = this.$route.params.id
            this.getInfo()
            this.queryAllTeacher();
        } else {
            this.queryAllTeacher()
            this.queryFirstLevelInfo()
        }


    },

    methods: {
        //上传封面成功调用的方法
        handleAvatarSuccess(res, file) {
            this.courseInfoVo.cover = res.data.url
        },

        getInfo() {
            getCourseInfoId(this.courseId).then(response => {
                this.courseInfoVo = response.data.courseInfoVo
                getAllSubject().then(response => {
                    this.subjectOneList = response.data.list
                    for (var i = 0; i < this.subjectOneList.length; i++) {
                        var oneSubject = this.subjectOneList[i];
                        if (this.courseInfoVo.subjectParentId == oneSubject.id) {
                            this.subjectTwoList = oneSubject.children
                        }
                    }
                })

            })
        },
        //上传之前调用的方法
        beforeAvatarUpload(file) {
            const isJPG = file.type === 'image/jpeg'
            const isLt2M = file.size / 1024 / 1024 < 2

            if (!isJPG) {
                this.$message.error('上传头像图片只能是 JPG 格式!')
            }
            if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过 2MB!')
            }
            return isJPG && isLt2M
        },
        update() {

        },
        saveOrUpdate() {
            if (!this.courseInfoVo.id) {
                //添加课程信息
                addCourse(this.courseInfoVo).then(response => {
                    this.$message({
                        type: 'success',
                        message: '添加课程信息成功!',
                    });
                    this.$router.push({ path: '/course/chapter/' + response.data.courseId })
                })
            } else {
                //保存课程信息
                updateCourseInfo(this.courseInfoVo).then(response=>{
                    this.$message({
                        type: 'success',
                        message: '修改课程信息成功!',
                    });
                    this.$router.push({ path: '/course/chapter/' + this.courseId })
                })
            }

        },
        //查询所有讲师信息
        queryAllTeacher() {
            getAllTeacher().then(response => {
                this.teacherList = response.data.items;
            })
        },
        //查询一级分类信息
        queryFirstLevelInfo() {
            getAllSubject().then(response => {
                this.subjectOneList = response.data.list;
            })
        },
        //点击某个一级分类触发change事件
        subjectLevelOneChanged(FirstLevelId) {
            for (let i = 0; i < this.subjectOneList.length; i++) {
                if (this.subjectOneList[i].id == FirstLevelId) {
                    this.subjectTwoList = this.subjectOneList[i].children;
                    this.courseInfoVo.subjectId = ''
                }
            }
        }

    }
}
</script>

<style scoped>
.tinymce-container {
    line-height: 29px;
}
</style>