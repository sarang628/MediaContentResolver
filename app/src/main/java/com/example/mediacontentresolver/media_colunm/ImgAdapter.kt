package com.example.mediacontentresolver.media_colunm

//class ImgAdapter : RecyclerView.Adapter<ImageViewHolder>() {
//    var picturePath = ArrayList<PictureDetail>()
//
//    fun setPicturePaths(list: ArrayList<PictureDetail>) {
//        picturePath = list
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
//        return ImageViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.item_img, parent, false)
//        )
//    }
//
//    override fun getItemCount(): Int {
//        return picturePath.size
//    }
//
//    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
//        Glide
//            .with(holder.itemView.context)
//            .load(picturePath[position].path)
//            .centerCrop()
//            .into(holder.itemView.findViewById(R.id.iv));
//
//        holder.itemView.findViewById<TextView>(R.id.tv_info).text = picturePath[position].info
//    }
//}