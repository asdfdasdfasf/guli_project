import request from '@/utils/request'
//根据课程id获取章节和小节数据列表
export function getAllChapter(id) {
  return request({
    url: `/serviceedu/chapter/list/${id}`,
    method: 'get',
  })
}
//添加章节信息
export function addChapter(chapter) {
  return request({
    url: `/serviceedu/chapter/addChapter`,
    method: 'post',
    data:chapter
  })
} 
//更新章节信息
export function updateChapter(chapter) {
  return request({
    url: `/serviceedu/chapter/updateChapter`,
    method: 'post',
    data:chapter
  })
} 

//删除章节信息
export function deleteChapter(chapterId) {
  return request({
    url: `/serviceedu/chapter/deleteChapter/${chapterId}`,
    method: 'post',
  })
}

//通过章节id获取章节信息
export function getChapter(chapterId) {
  return request({
    url: `/serviceedu/chapter/getChapter/${chapterId}`,
    method: 'get',
  })
} 
