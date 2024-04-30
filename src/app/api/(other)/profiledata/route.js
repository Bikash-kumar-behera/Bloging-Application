import { NextRequest, NextResponse } from "next/server";
import axios from "axios";
import { getDataFromToken } from "@/helpers/getDataFromToken";
import User from "@/models/userModel";
import { connect } from "@/dbConfig/dbConfig";

connect();

export async function POST(request) {
    try {
        const reqBody = await request.json();
        const { userId } = reqBody;

        const user = await User.findOne({ _id: userId });

        if (!user) {
            return NextResponse.json(
                { error: "User not found" },
                { status: 400 }
            );
        }

        const url = process.env.BACKEND_URL + `/post/${userId}/`;
        const url2 = process.env.BACKEND_URL + `/user/${userId}`;
        const posts = await axios.get(url);
        const users = await axios.get(url2);

        const responce = {
            posts: posts.data,
            user: users.data,
        }
        console.log(responce)

        return NextResponse.json({
            message: "Post featch successful",
            data: responce,
        });
    } catch (error) {
        return NextResponse.json({ error: error.message }, { status: 400 });
    }
}
