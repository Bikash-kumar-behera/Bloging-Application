import Markdown from "markdown-to-jsx";
import React, { useState } from "react";
// import { AiOutlineArrowRight } from "react-icons/ai";
import Link from "next/link";


const Card = ({ post, index, url }) => {

  return (
    <>
      <div
        key={post?._id}
        className={`w-full flex flex-col gap-4 items-center rounded      md:flex-row`}
        //  ${index / 2 === 0 ? "md:flex-row" : "md:flex-row-reverse"}
      >
        <Link
          href={`/post/${post.postId}`}
          className="w-full h-auto md:h-64 md:w-2/4 "
        >
          <img
            src={url+post?.postImagePath}
            alt={post?.title}
            className="object-cover w-full h-full rounded"
          />
        </Link>

        <div className="w-full md:w-2/4 flex flex-col gap-3">
          <div className="flex gap-2">
            <span className="text-sm text-gray-600">
              {new Date(post?.postCreationTime[0],post?.postCreationTime[1],post?.postCreationTime[2],post?.postCreationTime[3],post?.postCreationTime[4],post?.postCreationTime[5],post?.postCreationTime[6]).toLocaleString()}
            </span>
            <span className="text-sm text-rose-600 font-semibold">
              {post?.cat}
            </span>
          </div>

          <h6 className="text-xl flex justify-start 2xl:text-3xl font-semibold text-black dark:text-white">
            {post?.postTitle}
          </h6>

          <div className="flex-1 overflow-hidden text-gray-600 dark:text-slate-500 text-sm text-justify">
            <Markdown options={{ wrapper: "article" }}>
              {post?.postDescription?.slice(0, 140) + "..."}
            </Markdown>
          </div>

          <Link
            href={`/post/${post.postId}`}
            className="flex items-center gap-2 text-black dark:text-white"
          >
            <span className="underline">Read More</span> 
          </Link>
        </div>
      </div>
    </>
  );
};

export default Card;