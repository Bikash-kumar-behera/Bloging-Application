"use client";
// import Markdown from "markdown-to-jsx";
import { useEffect, useState } from "react";
import Markdown from "markdown-to-jsx";
import { posts, popular } from "@/utils/dummyData.js";

import Link from "next/link";
import PopularPosts from "@/components/other/PopularPosts";
import Carosal from "@/components/other/Carosal";
import PostComments from "@/components/other/PostComments";

const Pages = ({params}) => {
  const [popularPost, setPopularPost] = useState(popular);

  const { id } = params;
// this id for post id
  // const id = "655b3f037a397a2c8546c2f5";

  const [post, setPost] = useState(null);
  const posts = {
    _id: "655ad816d148ee58ab8d58a1",
    title: "Fullstack Social Media App - Full Code",
    slug: "fullstack-social-media-app-full-code",
    desc: '<p>Full-Stack Social Media Application using ReactJs, Tailwind CSS for the front end and NodeJs, ExpressJs and MongoDb for backend.</p><p style="text-align: start">This App is fully responsive. This project includes for frontend (UI Design) and Backend (Server).</p><p style="text-align: start"></p><p style="text-align: start"></p><h1><strong>Functionalities:</strong></h1><p></p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">1.</span> User Authentication and Authorisation</p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">2.</span> Email Verification</p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">3.</span> Password reset</p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">4.</span> Create Post</p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">5.</span> Advance Comment system (comments with sub coments)</p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">6.</span> Like post and comments</p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">7.</span> Delete post</p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">8.</span> Friend Request (send request, accept or deby)</p><p style="text-align: start">and others.....</p><p style="text-align: start"></p><p style="text-align: start"></p><p style="text-align: start"></p><h1><strong>Getting Started</strong></h1><p></p><p style="text-align: start"></p><p style="text-align: start"></p><h1><strong>SERVER OR BACKEND</strong></h1><p></p><p style="text-align: start">Firstly move to the server directory eg: cd server</p><p style="text-align: start"></p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">1.</span> Create a <code>.env</code> file</p><p style="text-align: start">&nbsp;&nbsp;The .env file will contain the following:</p><p style="text-align: start">&nbsp;&nbsp;i. MONGODB_URL = <code>database connection string</code></p><p style="text-align: start">&nbsp;&nbsp;ii. JWT_SECRET_KEY = <code>your secreate key</code></p><p style="text-align: start">&nbsp;&nbsp;iii. PORT = <code>8800</code></p><p style="text-align: start">&nbsp;&nbsp;iv. AUTH_EMAIL= <code>email address</code></p><p style="text-align: start">&nbsp;&nbsp;v. AUTH_PASSWORD= <code>email access password</code></p><p style="text-align: start">&nbsp;&nbsp;vi. APP_URL = <code>http://localhost:8800</code></p><p style="text-align: start"></p><p style="text-align: start">&nbsp;&nbsp;Note: I used hotmail account to send verification email, so you can just create one because hotmail account is reliable in product and has no configuration.</p><p style="text-align: start"></p><p style="text-align: start">&nbsp;&nbsp;Alos, change <code>API_URL</code> when you deploy your app else use localhost with the appropriate <code>port number</code></p><p style="text-align: start"></p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">2.</span> Run <code>npm install</code> to install the packages</p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">3.</span> Run <code>npm start</code> to start the server</p><p style="text-align: start"></p><p style="text-align: start"></p><h1><strong>VIEWS FILE</strong></h1><p></p><p style="text-align: start">In the view are the static html files to be use for <code>email verfication</code> and <code>password reset</code>.</p><p style="text-align: start"></p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">1.</span> This folder is a React App</p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">2.</span> navigate in the folder and install it dependencies</p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">3.</span> make changes to suit your preference and run build</p><p style="text-align: start"><span style="color: rgb(103, 150, 230)">4.</span> copy the build folder into the view folder in the server folder</p><p style="text-align: start"></p><p style="text-align: start"><strong>Override the existing one.</strong></p><p style="text-align: start">NOTE: During deployment make sure you change the various links in the view file and build it again and replace the files in the view folder of the server folder.</p><p style="text-align: start"></p><p style="text-align: start"></p><p style="text-align: start"></p><h1><strong>CLINET SIDE</strong></h1><p></p><p style="text-align: start"></p><p style="text-align: start">The client or frontend also has .env filde in the root folder.</p><p style="text-align: start">Create an environment variable of name <code>REACT_APP_CLOUDINARY_ID</code>.</p><p style="text-align: start">This will store the cloudinary cloud name</p><p style="text-align: start"></p><p style="text-align: start">This side also has and env file with <code>REACT_APP_CLOUDINARY_ID</code></p>',
    img: "https://firebasestorage.googleapis.com/v0/b/blogwave-4bb76.appspot.com/o/1700452314589Codewave%20(1).png?alt=media&token=ee4b428f-0df4-47ec-af24-51ca1282f1a5",
    cat: "CODING",

    user: {
      _id: "655ad72bd148ee58ab8d5871",
      name: "Akwasi Asante",
      image:
        "https://firebasestorage.googleapis.com/v0/b/blogwave-4bb76.appspot.com/o/1700452069593FB_IMG_1608124167539-removebg%20(1).png?alt=media&token=c2270464-bc4f-4ec3-8ea7-39ca905621b5",
    },
    comments: [
      "655c13510f6afc38e16cb28a",
      "655c344846a378c9c55ff301",
      "655c34ad46a378c9c55ff313",
    ],
    status: true,
    createdAt: "2023-11-20T03:52:54.673Z",
    updatedAt: "2023-11-22T07:12:43.796Z",
    __v: 0,
  };


  

  return (
    <div className="w-full  px-0 md:px-4 py-6 2xl:px-10">
      <div className="w-full flex flex-col-reverse md:flex-row gap-2 gap-y-5 items-center">
        <img
          src={posts?.img}
          alt={posts?.title}
          className="w-full md:w-full h-64 md:h-[460px] 2xl:h-[580px] rounded "
        />
      </div>
      <div className="w-full flex flex-col md:flex-row gap-10 2xl:gap-x-28 mt-8">
        <Link href={`/writer/${posts?.user?._id}`} className="w-3/4 flex  md:flex-row gap-6 2xl:gap-x-14 mt-6">
          <img
            src={posts?.user?.image}
            alt={posts?.user?.name}
            className="w-8 h-8 rounded-full"
          />
          <h1 className="text-xl md:text-3xl font-bold text-slate-800 dark:text-white">
            {posts?.user?.name}
          </h1>
        </Link>
        <span className="text-slate-700 text-xl w-1/4  flex justify-center items-center italic">
          {new Date(posts?.createdAt).toDateString()}
        </span>
      </div>

      <div className="w-full flex flex-col md:flex-row gap-10 2xl:gap-x-28 mt-8">
        <h1 className="text-3xl md:text-5xl font-bold text-slate-800 dark:text-white">
          {posts?.title}
        </h1>
      </div>

      <div className="w-full flex flex-col md:flex-row gap-8 2xl:gap-x-28 mt-8">
        {/* LEFT */}
        <div className="w-full  flex flex-col text-black dark:text-gray-500 ">
          {posts?.desc && (
            <Markdown
              options={{ wrapper: "article" }}
              className="leading-[1.5rem] text-base 2xl:text-[20px]"
            >
              {posts?.desc}
            </Markdown>
          )}
        </div>

        {/* RIGHT */}
        {/* <div className="w-full md:w-1/4 flex flex-col gap-y-12">
          <PopularPosts posts={popular?.posts} category={post?.cat} />
        </div> */}
      </div>

      {/* COMMENTS SECTION */}
      <div className="w-full">
        {<PostComments postId="655b3f037a397a2c8546c2f5" />}
      </div>
    </div>
  );
};

export default Pages;
