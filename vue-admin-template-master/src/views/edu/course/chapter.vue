<template>

  <div class="app-container">

    <h2 style="text-align: center;">发布新课程</h2>

    <el-steps :active="2" process-status="wait" align-center style="margin-bottom: 40px;">
      <el-step title="填写课程基本信息" />
      <el-step title="创建课程大纲" />
      <el-step title="最终发布" />
    </el-steps>

    <el-button type="text" @click="openChapterDialog()">添加章节</el-button>
    <!-- 章节 -->
    <ul class="chanpterList">
      <li v-for="chapter in chapterVoList" :key="chapter.id">
        <p>
          {{ chapter.title }}
          <span class="acts">
            <el-button type="text" @click="openVideo(chapter.id)">添加小节</el-button>
            <el-button style="" type="text" @click="openEditChapter(chapter.id)">编辑</el-button>
            <el-button type="text" @click="openDeleteChapter(chapter.id)">删除</el-button>
          </span>
        </p>

        <!-- 视频 -->
        <ul class="chanpterList videoList">
          <li v-for="video in chapter.videoVoList" :key="video.id">
            <p>{{ video.title }}
              <span class="acts">
                <el-button type="text" @click="openEditVideo(video.id)">编辑</el-button>
                <el-button type="text" @click="openDeleteVideo(video.id)">删除</el-button>
              </span>
            </p>
          </li>
        </ul>
      </li>
    </ul>
    <div>
      <el-button @click="previous">上一步</el-button>
      <el-button :disabled="saveBtnDisabled" type="primary" @click="next">下一步</el-button>
    </div>
    <!-- 添加和修改章节表单 -->
    <el-dialog :visible.sync="dialogChapterFormVisible" title="添加章节">
      <el-form :model="chapter" label-width="120px">
        <el-form-item label="章节标题">
          <el-input v-model="chapter.title" />
        </el-form-item>
        <el-form-item label="章节排序">
          <el-input-number v-model="chapter.sort" :min="0" controls-position="right" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogChapterFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 添加和修改课时表单 -->
    <el-dialog :visible.sync="dialogVideoFormVisible" title="添加课时">
      <el-form :model="video" label-width="120px">
        <el-form-item label="课时标题">
          <el-input v-model="video.title" />
        </el-form-item>
        <el-form-item label="课时排序">
          <el-input-number v-model="video.sort" :min="0" controls-position="right" />
        </el-form-item>
        <el-form-item label="是否免费">
          <el-radio-group v-model="video.free">
            <el-radio :label="true">免费</el-radio>
            <el-radio :label="false">默认</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="上传视频">
          <!-- TODO -->
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVideoFormVisible = false">取 消</el-button>
        <el-button :disabled="saveVideoBtnDisabled" type="primary" @click="saveOrUpdateVideo">确 定</el-button>
      </div>
    </el-dialog>


  </div>
</template>
<script>
import { getAllChapter } from '../../../api/edu/chapter'
import { updateChapter } from '../../../api/edu/chapter'
import { deleteChapter } from '../../../api/edu/chapter'
import { addChapter } from '../../../api/edu/chapter'
import { getChapter } from '../../../api/edu/chapter'
import { addVideo } from '../../../api/edu/video'
import { deleteVideo } from '../../../api/edu/video'
import { getVideoById } from '../../../api/edu/video'
import {updateVideoById} from '../../../api/edu/video'
export default {
  data() {
    return {
      saveBtnDisabled: false,
      chapterVoList: [],
      courseId: [],
      dialogChapterFormVisible: false,
      dialogVideoFormVisible: false,
      chapter: {
        title: '',
        sort: 0
      },
      saveVideoBtnDisable: false,
      video: {
        title: '',
        sort: 0,
        free: 0,
        videoSourceId: '',
        videoOriginalName: ''//视频名称
      }
    }
  },
  created() {
    if (this.$route.params && this.$route.params.id) {
      this.courseId = this.$route.params.id
      this.getChapterVideo()
    }
  },
  methods: {
    //**************小节操作*************** */
    //添加小节弹框的方法
    openVideo(chapterId) {
      //弹框
      this.dialogVideoFormVisible = true
      //设置章节id
      this.video.chapterId = chapterId

    },
    //添加小节
    addVideo() {
     
      this.video.courseId = this.courseId
      addVideo(this.video).then(response => {
        this.dialogVideoFormVisible = false
        this.$message({
          type: 'success',
          message: '添加小节信息成功!',
        });
         //清空表单数据
        this.video.title=''
        this.getChapterVideo()
      })
    },
    //回显小节信息
    getVideoById(videoId) {
      this.dialogVideoFormVisible = true
      getVideoById(videoId).then(response => {
        this.video = response.data.video
      })
    },
    //打开编辑小节信息
    openEditVideo(videoId) {
      this.getVideoById(videoId)
    },
    //删除小节信息
    openDeleteVideo(videoId) {
      this.$confirm('此操作将删除小节信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteVideo(videoId).then(response => {
          this.getChapterVideo()
        })
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      })
    },
    //更新小节
    updateVideo() {
      updateVideoById(this.video).then(response=>{
         this.dialogVideoFormVisible = false
        this.$message({
          type: 'success',
          message: '更新小节信息成功!',
        });
        this.getChapterVideo()
      })
    },
    //保存或者修改小节信息
    saveOrUpdateVideo() {
      if (this.video.id) {
        this.updateVideo();
      } else {
        this.addVideo()
      }
    },

    //**************章节操作*************** */
    getChapterVideo() {
      getAllChapter(this.courseId).then(response => {
        this.chapterVoList = response.data.chapterVoList
      })
    },
    //章节数据回显
    openEditChapter(chapterId) {
      //弹窗
      this.dialogChapterFormVisible = true
      //返回数据对象
      getChapter(chapterId).then(response => {
        this.chapter.title = response.data.chapter.title
        this.chapter.sort = response.data.chapter.sort
        this.chapter.id = response.data.chapter.id
      })
    },
    //添加章节信息
    addChapter() {
      this.chapter.courseId = this.courseId
      addChapter(this.chapter).then(response => {
        this.dialogChapterFormVisible = false
        this.$message({
          type: 'success',
          message: '添加章节信息成功!',
        });
        this.getChapterVideo()
      })
    },
    //删除章节信息
    openDeleteChapter(chapterId) {
      this.$confirm('此操作将删除章节信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteChapter(chapterId).then(response => {
          this.getChapterVideo()
        })
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    //更新章节信息
    updateChapter() {
      updateChapter(this.chapter).then(response => {
        this.dialogChapterFormVisible = false
        this.$message({
          type: 'success',
          message: '更新章节信息成功!',
        });
        this.getChapterVideo()
      })
    },
    //保存或者更新章节信息
    saveOrUpdate() {
      if (this.chapter.id) {
        this.updateChapter()
      } else {
        this.addChapter();
      }
    },
    //打开弹窗对话
    openChapterDialog() {
      this.dialogChapterFormVisible = true;
      this.chapter.title = ''
      this.chapter.sort = 0
      this.chapter.id = ''
    },
    previous() {
      this.$router.push({ path: '/course/info/' + this.courseId })
    },
    next() {
      //跳转到第二步
      this.$router.push({ path: '/course/publish/' + this.courseId })
    }
  }
}
</script>
<style scoped>
.chanpterList {
  position: relative;
  list-style: none;
  margin: 0;
  padding: 0;
}

.chanpterList li {
  position: relative;
}

.chanpterList p {
  float: left;
  font-size: 20px;
  margin: 10px 0;
  padding: 10px;
  height: 70px;
  line-height: 50px;
  width: 100%;
  border: 1px solid #DDD;
}

.chanpterList .acts {
  float: right;
  font-size: 14px;
}

.videoList {
  padding-left: 50px;
}

.videoList p {
  float: left;
  font-size: 14px;
  margin: 10px 0;
  padding: 10px;
  height: 50px;
  line-height: 30px;
  width: 100%;
  border: 1px dotted #DDD;
}
</style>