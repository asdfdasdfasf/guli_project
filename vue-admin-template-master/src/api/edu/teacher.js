import request from '@/utils/request'
//条件查询展示讲师列表
export function getTeacherListPage(pageNo,limit,teacherVo) {
  return request({
    url: `/serviceedu/edu-teacher/${pageNo}/${limit}`,
    method: 'post',
    //条件对象，后端使用RequestBody获取对象,data表示将对象转化成json传递
    data: teacherVo
  })
}
//逻辑删除讲师
export function deleteTeacherById(id) {
  return request({
    url: `/serviceedu/edu-teacher/${id}`,
    method: 'delete',
  })
}

//添加讲师信息
export function saveTeacher(teacher) {
  return request({
    url: `/serviceedu/edu-teacher/save`,
    method: 'post',
    data: teacher
  })
}
//根据id查询讲师信息
export function queryTeacherById(id) {
  return request({
    url: `/serviceedu/edu-teacher/${id}`,
    method: 'get',
  })
}
//更新讲师信息
export function updateTeache(id,teacher) {
  return request({
    url: `/serviceedu/edu-teacher/${id}`,
    method: 'post',
    data: teacher
  })
}

