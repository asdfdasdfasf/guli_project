import request from '@/utils/request'
//添加小节信息
export function addVideo(eduVideo) {
  return request({
    url: `/serviceedu/video/addVideo`,
    method: 'post',
    data:eduVideo
  })
}
//删除小节信息
export function deleteVideo(videoId) {
    return request({
      url: `/serviceedu/video/deleteVideo/${videoId}`,
      method: 'post',
    })
  }

//根据id查询小节的信息
export function getVideoById(videoId) {
  return request({
    url: `/serviceedu/video/getVideo/${videoId}`,
    method: 'get',
  })
}

//根据id值更新小节的信息
export function updateVideoById(eduVideo) {
  return request({
    url: `/serviceedu/video/updateVideo/`,
    method: 'post',
    data:eduVideo
  })
}