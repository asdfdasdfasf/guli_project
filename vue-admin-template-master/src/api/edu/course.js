import request from '@/utils/request'
//查询课程分类信息
export function addCourse(courseInfoVo) {
  return request({
    url: `/serviceedu/edu-course/addCourse`,
    method: 'post',
    data:courseInfoVo
  })
}
//查询所有讲师
export function getAllTeacher() {
    return request({
      url: `/serviceedu/edu-teacher/getAll`,
      method: 'get',
    })
  }

  //根据课程id查询课程基本信息
export function getCourseInfoId(courseId) {
  return request({
    url: `/serviceedu/edu-course/getCourseInfo/${courseId}`,
    method: 'get',
  })
}

//修改课程信息
export function updateCourseInfo(courseInfoVo) {
  return request({
    url: `/serviceedu/edu-course/updateCourseInfo`,
    method: 'post',
    data:courseInfoVo
  })
}