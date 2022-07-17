import request from '@/utils/request'
//查询课程分类信息
export function getAllSubject() {
  return request({
    url: `/serviceedu/subject/subjectAll`,
    method: 'get'
  })
}